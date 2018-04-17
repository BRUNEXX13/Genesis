package com.bss.sistema.genesis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bss.sistema.genesis.model.Proposta;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	//Apontamento para Propostas 
	@RequestMapping("/novo")
	public String novo(Proposta proposta) // Propost Disponivel na Requiscao
	{
		// 
		return "cliente/CadastroCliente";
	}

	
}
