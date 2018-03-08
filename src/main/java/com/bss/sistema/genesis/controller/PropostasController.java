package com.bss.sistema.genesis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.model.Sabor;
import com.bss.sistema.genesis.repository.Bancos;

@Controller
public class PropostasController {

	@Autowired // Chamando meu Repository - Propostas
	private Bancos bancos;

	// Apontamento para Propostas
	@RequestMapping("/propostas/novo")

	public ModelAndView novo(Proposta proposta) // Propost Disponivel na Requiscao
	{
		ModelAndView mv = new ModelAndView("proposta/CadastroProposta");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("bancos", bancos.findAll());

		return mv;

	public String novo(Proposta proposta) // Propost Disponivel na Requiscao
	{	//propostas.findAll(); // retornando todas propostas
		
		return "proposta/CadastroProposta";

	}

	// Recebendo do Model //
	@RequestMapping(value = "/propostas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Proposta proposta, BindingResult result, Model model,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(proposta); // Retorna o View novo proposta

		}

		// Salvar no banco de Dados//
		attributes.addFlashAttribute("mensagem", "Proposta Salva com Sucesso !");
		// Salvo redireciona para pagina Propostas/novo com Redirect // Melhor com que
		// Forward
		return new ModelAndView("redirect:/propostas/novo"); // Redireciona para nova pagina

	}

	// Acessando a view
	@RequestMapping("/propostas/cadastro")
	public String cadastro() {
		return "proposta/cadastro-produto";
	}

}