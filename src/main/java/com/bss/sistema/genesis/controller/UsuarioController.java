package com.bss.sistema.genesis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bss.sistema.genesis.model.Proposta;

@Controller
public class UsuarioController {

	// Apontamento para Propostas
	@RequestMapping("/propostas/usuario")
	public String usuario(Proposta proposta) // Propost Disponivel na Requiscao
	{
		return "usuario/CadastroUsuario";
	}
}
