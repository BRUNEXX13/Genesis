package com.bss.sistema.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bss.sistema.model.Proposta;

@Controller
public class ProdutoController {

	
	//Apontamento para Propostas 
	@RequestMapping("/propostas/produto")
	public String novo(Proposta proposta) // Propost Disponivel na Requiscao
	{
		// 
		return "proposta/CadastroProduto";
	}

	
}