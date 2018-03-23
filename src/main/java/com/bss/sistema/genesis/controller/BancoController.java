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

import com.bss.sistema.genesis.model.Banco;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.service.CadastroBancoService;

@Controller
public class BancoController {

	// Referencia lista de bancos
	@Autowired
	private Bancos bancos;

	@Autowired
	private CadastroBancoService cadastroBancoService;
	
		
	// Apontamento para Bancos
	@RequestMapping("/propostas/banco/novo") // aqui é o get. depois muda se quiser
	public ModelAndView novo(Banco banco) { // Propost Disponivel na Requiscao não sei pq diabos ele consegue achar a u
		ModelAndView mv = new ModelAndView("/banco/CadastroBanco");
		mv.addObject("bancos", bancos.findAll()); // Referencia Lista de Bancos - AutoWired
		return mv;
	}

	@RequestMapping(value = "/bancos/novo", method = RequestMethod.POST) // aqui é o post
	public ModelAndView cadastrar(@Valid Banco banco, BindingResult result, Model model, RedirectAttributes attributes) {
		  if (result.hasErrors()) {
			  System.out.println(">>> sku: " + banco.getNumero());
			  return novo(banco);
		   }
		cadastroBancoService.salvar(banco);
		attributes.addFlashAttribute("mensagem", "Banco salvo com sucesso!!");
		// Salvar no banco de dados...
		//attributes.addFlashAttribute("mensagem", "Banco salva com sucesso!");
		System.out.println(">>> sku: " + banco.getNumero());
		//System.out.println(">>> sku: " + banco.getNome());
		return new ModelAndView("redirect:/propostas/banco/novo");
	}

}