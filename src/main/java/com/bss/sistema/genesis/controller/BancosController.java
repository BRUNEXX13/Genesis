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

import com.bss.sistema.genesis.model.Banco;
import com.bss.sistema.genesis.model.TipoConta;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.repository.Contas;
import com.bss.sistema.genesis.service.CadastroBancoService;
import com.bss.sistema.genesis.service.exception.NomeBancoJaCadastradoException;
import com.bss.sistema.genesis.service.exception.NumeroBancoJacadastradoException;

@Controller
@RequestMapping("/bancos")
public class BancosController {

	// Referencia lista de bancos
	@Autowired
	private Bancos bancos;
	
	@Autowired
	private Contas contas;

	@Autowired
	private CadastroBancoService cadastroBancoService;

	// Apontamento para Bancos
	@RequestMapping("/novo") // aqui é o get. depois muda se quiser
	public ModelAndView novo(Banco banco) { // Propost Disponivel na Requiscao não sei pq diabos ele consegue achar a u
		ModelAndView mv = new ModelAndView("/banco/CadastroBanco");
		mv.addObject("bancos", bancos.findAll()); // Referencia Lista de Bancos - AutoWired
		mv.addObject("tipos", TipoConta.values());
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST) // aqui é o post
	public ModelAndView cadastrar(@Valid Banco banco, BindingResult result, Model model,
			RedirectAttributes attributes) throws Throwable {
		if (result.hasErrors()) {
			// System.out.println(">>> sku: " + banco.getNumero());
			return novo(banco);
		}

			try {
			
			cadastroBancoService.salvar(banco);
		} catch (NomeBancoJaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(banco);
		} catch (NumeroBancoJacadastradoException e) {
			result.rejectValue("numero", e.getMessage(), e.getMessage());
			
			return novo(banco);

		}
		
		
		
		
		
		attributes.addFlashAttribute("mensagem", "Banco salvo com sucesso!!");
		// Salvar no banco de dados...
		// attributes.addFlashAttribute("mensagem", "Banco salva com sucesso!");
		System.out.println(">>> sku: " + banco.getNumero());
		// System.out.println(">>> sku: " + banco.getNome());
		return new ModelAndView("redirect:/bancos/novo");
	}

	// Recebendo Requisivcao Via Post// Cadastrado Rapido
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Banco banco, BindingResult result) throws Throwable {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}
		try {
			banco = cadastroBancoService.salvar(banco);
		} catch (NomeBancoJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(banco);
	}

}