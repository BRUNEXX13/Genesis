package com.bss.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bss.sistema.model.Proposta;

@Controller
public class ClienteController {

	//Apontamento para Propostas 
	@RequestMapping("/propostas/cliente")
	public String novo(Proposta proposta) // Propost Disponivel na Requiscao
	{
		// 
		return "cliente/CadastroCliente";
	}

	
}
