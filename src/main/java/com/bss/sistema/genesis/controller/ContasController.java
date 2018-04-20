package com.bss.sistema.genesis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bss.sistema.genesis.model.Conta;
import com.bss.sistema.genesis.model.TipoConta;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.repository.Usuarios;
import com.bss.sistema.genesis.service.CadastroContaService;
import com.bss.sistema.genesis.service.exception.NomeContaJaCadastradoException;

@Controller
@RequestMapping("/contas")
public class ContasController {

	@Autowired
	private Bancos bancos;
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private CadastroContaService cadastroContaService;

	// Apontamento para Bancos
	@RequestMapping("/novo") // aqui é o get. depois muda se quiser
	public ModelAndView novo(Conta conta) { // Propost Disponivel na Requiscao não sei pq diabos ele consegue achar a u
		ModelAndView mv = new ModelAndView("/conta/CadastroConta");
		mv.addObject("bancos", bancos.findAll());
		mv.addObject("tipos", TipoConta.values());
		mv.addObject("usuarios", usuarios.findAll());
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST) // aqui é o post
	public ModelAndView cadastrar(@Valid Conta conta, BindingResult result, Model model,RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println(">>> sku: " + conta.getNumero());
			return novo(conta);
		}
		try {
			cadastroContaService.salvar(conta);
		} catch (NomeContaJaCadastradoException e) {
			result.rejectValue("numero", e.getMessage(), e.getMessage());
			return novo(conta);
		}
		attributes.addFlashAttribute("mensagem", "Conta salva com sucesso!!");
		// Salvar no banco de dados...
		// attributes.addFlashAttribute("mensagem", "Banco salva com sucesso!");
		System.out.println(">>> sku: " + conta.getTipoConta());

		return new ModelAndView("redirect:/contas/novo");
	}

	// Recebendo dados VIA JSON
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Conta conta, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("agencia").getDefaultMessage());
		}
		try {
			conta = cadastroContaService.salvar(conta);
		} catch (NomeContaJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
		return ResponseEntity.ok(conta);

	}

}
