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

import com.bss.sistema.genesis.model.Origem;
import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.model.Sabor;
import com.bss.sistema.genesis.repository.Bancos;

@Controller
public class PropostasController {

	@Autowired
	private Bancos bancos;
	
	@RequestMapping("/propostas/novo")
	public ModelAndView novo(Proposta proposta) {
		ModelAndView mv = new ModelAndView("/proposta/CadastroProposta");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("bancos",bancos.findAll());
		mv.addObject("origens", Origem.values());
		
		return mv;
	}
	
	@RequestMapping(value = "/propostas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Proposta proposta, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(proposta);
		}
		
		// Salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "Proposta Salva com sucesso!");
	//	System.out.println(">>> sku: " + proposta.getAde());
		return new ModelAndView("redirect:/proposta/novo");
}
	
}