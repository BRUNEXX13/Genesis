package com.bss.sistema.genesis.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bss.sistema.genesis.model.Proposta;

@Controller
public class BancoController {

	
	//Apontamento para Propostas 
	@RequestMapping("/propostas/banco")
	public String novo(Proposta proposta) // Propost Disponivel na Requiscao
	{
		// 
		return "banco/CadastroBanco";
	}

	
}
