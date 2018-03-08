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

import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.model.Sabor;
import com.bss.sistema.genesis.repository.Bancos;

@Controller
public class PropostasController {
	
	//Injetando Bancos  em Propostas Repository-
	@Autowired
	private Bancos bancos;
	
<<<<<<< HEAD
	
	@RequestMapping("propostas/novo")
	public ModelAndView novo(Proposta proposta) {
		ModelAndView mv = new ModelAndView("proposta/CadastroProposta");
		
		mv.addObject("bancos",bancos.findAll());
		//Trazendo todos os bancos para Proposta
		//<option th:each="banco : ${bancos}" th:value="${banco.codigo}" th:text="{banco.nome}"
=======

	// Apontamento para Propostas
	@RequestMapping("/propostas/novo")
	public String novo(Proposta proposta) // Propost Disponivel na Requiscao
	{	//propostas.findAll(); // retornando todas propostas
>>>>>>> 135080893c0046c497abc34719686b0a5de080f9
		
		
		mv.addObject("sabores", Sabor.values()); // Passando um Array
		//<option th:each="sabor : ${sabores}" th:value="${sabor}">Adocicada</option>//
		return mv;
	}

	@RequestMapping(value = "/propostas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Proposta proposta, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(proposta);
		}
		attributes.addFlashAttribute("mensagem", "Proposta salva com sucesso");
		System.out.println(">>>>>> ade" + proposta.getAde());
		return new ModelAndView("redirect:/propostas/novo"); 
	}

}