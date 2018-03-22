package com.bss.sistema.genesis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bss.sistema.genesis.model.Usuario;

@Controller
public class UsuarioController {

	// Apontamento para Propostas
	@RequestMapping("/propostas/usuario")
	public ModelAndView banco(Usuario usuario) // Propost Disponivel na Requiscao
	{
		ModelAndView mv = new ModelAndView("/usuario/CadastroUsuario");

		return mv;
	}

}