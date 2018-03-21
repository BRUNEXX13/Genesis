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
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.repository.Produtos;
import com.bss.sistema.genesis.repository.Tabelas;

@Controller
public class PropostasController {

	@Autowired
	private Bancos bancos;
	
	@Autowired
	private Tabelas tabelas;
	
	@Autowired
	private Produtos produtos;
	
	

	
	
	@RequestMapping("/propostas/novo")
	public ModelAndView novo(Proposta proposta) {
		ModelAndView mv = new ModelAndView("/proposta/CadastroProposta");
		mv.addObject("bancos",bancos.findAll());
		mv.addObject("produtos", produtos.findAll());
		mv.addObject("origens", Origem.values());
		mv.addObject("tabelas", tabelas.findAll());
		
		return mv;
	}
	
	@RequestMapping(value = "/propostas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Proposta proposta, BindingResult result, Model model, RedirectAttributes attributes) {
		//if (result.hasErrors()) {
			//return novo(proposta);
		//}
		
		// Salvar no banco de dados...
		
		attributes.addFlashAttribute("mensagem", "Proposta Salva com sucesso!");
		System.out.println(">>>> codigo : "	    + proposta.getCodigo());
		System.out.println(">>>> ade : " 		+ proposta.getAde());
		System.out.println(">>>> descricao : " 	+ proposta.getDescricao());
		System.out.println(">>>> origem : " 	+ proposta.getOrigem());
		System.out.println(">>>> tabela : " 	+ proposta.getTabela());
		System.out.println(">>>> parcela : " 	+ proposta.getValorParcela());
		System.out.println(">>>> total : " 		+ proposta.getValorTotal());
		System.out.println(">>>> liquido : " 		+ proposta.getValorLiquido());
		
		return new ModelAndView("redirect:/propostas/novo");
	}
	
}