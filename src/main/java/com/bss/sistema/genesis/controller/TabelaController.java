package com.bss.sistema.genesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bss.sistema.genesis.model.Tabela;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.repository.Produtos;

@Controller
public class TabelaController {

	@Autowired
	private Bancos bancos;
	
	@Autowired
	private Produtos produtos;

	// Apontamento para Propostas
	@RequestMapping("/propostas/tabela")
	public ModelAndView banco(Tabela tabela) // Propost Disponivel na Requiscao
	{
		ModelAndView mv = new ModelAndView("/tabela/CadastroTabela");
		mv.addObject("bancos", bancos.findAll());
		mv.addObject("produtos", produtos.findAll());
		return mv;
	}

}
