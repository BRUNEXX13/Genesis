package com.bss.sistema.genesis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bss.sistema.genesis.model.Cliente;
import com.bss.sistema.genesis.model.Genero;
import com.bss.sistema.genesis.model.TipoConta;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.repository.Contas;
import com.bss.sistema.genesis.service.CadastroClienteService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private Contas contas;

	@Autowired
	private Bancos bancos;



	@Autowired
	private CadastroClienteService cadastroClienteService;

	// Apontamento para Propostas
	@RequestMapping("/novo")
	public ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("/cliente/CadastroCliente");
		mv.addObject("generos", Genero.values());
		mv.addObject("contas", contas.findAll());
		mv.addObject("bancos", bancos.findAll());
		mv.addObject("tipos", TipoConta.values());
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST) // aqui é o post
	public ModelAndView cadastrar(@Valid Cliente cliente, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			// System.out.println(">>> sku: " + banco.getNumero());
			return novo(cliente);
		}
		cadastroClienteService.salvar(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!!");
		;
		return new ModelAndView("redirect:/clientes/novo");
	}

}
