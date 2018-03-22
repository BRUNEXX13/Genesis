package com.bss.sistema.genesis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bss.sistema.genesis.model.Produto;
import com.bss.sistema.genesis.repository.Bancos;

@Controller
public class ProdutoController {
	
	@Autowired
	private Bancos bancos;

	//Apontamento para Propostas 
	@RequestMapping("/propostas/produto")
	public ModelAndView novo(Produto produto) {   // Propost Disponivel na Requiscao
	ModelAndView mv = new ModelAndView("/produto/CadastroProduto");
	mv.addObject("bancos",bancos.findAll());
		return mv;
	}

	
}
