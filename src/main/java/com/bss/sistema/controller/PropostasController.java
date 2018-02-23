package com.bss.sistema.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bss.sistema.model.Proposta;

@Controller
public class PropostasController {

	
	//Apontamento para Propostas 
	@RequestMapping("/propostas/novo")
	public String novo(Proposta proposta) // Propost Disponivel na Requiscao
	{
		// 
		return "proposta/CadastroProposta";
	}

	// Recebendo do Model //
	@RequestMapping(value = "/propostas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Proposta proposta, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(proposta); // Retorna o View novo proposta
			
		}
		
		// Salvar no banco de Dados//
		attributes.addFlashAttribute("mensagem", "Proposta Salva com Sucesso !");
		// Salvo redireciona para pagina Propostas/novo com Redirect // Melhor com que Forward
		return "redirect:/propostas/novo"; // Redireciona para nova pagina
		
	}
	// Acessando a view
	@RequestMapping("/propostas/cadastro")
	public String cadastro() {
		return "proposta/cadastro-produto";
	}
	
}
