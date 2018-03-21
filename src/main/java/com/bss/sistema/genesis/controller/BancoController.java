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
import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.repository.Bancos;

@Controller
public class BancoController {

	// Referencia lista de bancos
	@Autowired
	private Bancos bancos;

	// Apontamento para Bancos
	@RequestMapping("/propostas/banco")
	public ModelAndView banco(Proposta proposta) { // Propost Disponivel na Requiscao
		ModelAndView mv = new ModelAndView("/banco/CadastroBanco");
		mv.addObject("bancos", bancos.findAll()); // Referencia Lista de Bancos - AutoWired
		return mv;
	}

	@RequestMapping(value = "/bancos/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Banco banco, BindingResult result, Model model, RedirectAttributes attributes) {

		attributes.addFlashAttribute("mensagem", "Banco Salvo com Sucesso");
		System.out.println(">>>> codigo: " + banco.getCodigo());
		System.out.println(">>>> numero " + banco.getNumero());
		System.out.println(">>>> nome: " + banco.getNome());

		return new ModelAndView("redirect:/bancos/novo");

	}

}
