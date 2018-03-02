package com.bss.sistema.genesis.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bss.sistema.genesis.model.Proposta;

@Controller
public class ProdutoController {

	
	//Apontamento para Propostas 
	@RequestMapping("/propostas/produto")
	public String novo(Proposta proposta) // Propost Disponivel na Requiscao
	{
		// 
		return "produto/CadastroProduto";
	}

	
}
