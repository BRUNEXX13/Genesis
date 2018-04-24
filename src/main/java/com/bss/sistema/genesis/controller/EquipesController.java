package com.bss.sistema.genesis.controller;

import javax.validation.Valid;

import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bss.sistema.genesis.model.Equipe;
import com.bss.sistema.genesis.repository.Equipes;
import com.bss.sistema.genesis.repository.Usuarios;
import com.bss.sistema.genesis.service.CadastroEquipeService;
import com.bss.sistema.genesis.service.exception.NomeEquipeJaCadastradoException;


@Controller
@RequestMapping("/equipes")
public class EquipesController {

	@Autowired
	private Equipes equipes;

	@Autowired
	private Usuarios usuarios;

	@Autowired
	private CadastroEquipeService cadastroEquipeService;

	// Apontamento para Bancos
	@RequestMapping("/novo") //
	public ModelAndView novo(Equipe equipe) { //
		ModelAndView mv = new ModelAndView("/equipe/CadastroEquipe");
		mv.addObject("usuarios", usuarios.findAll());
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST) // aqui é o post
	public ModelAndView cadastrar(@Valid Equipe equipe, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			// System.out.println(">>> sku: " + banco.getNumero());
			return novo(equipe);
		}
		
		try {
			cadastroEquipeService.salvar(equipe);
			 } catch(NomeEquipeJaCadastradoException e) {
				 result.rejectValue("nome", e.getMessage(), e.getMessage());
				 return novo(equipe);
			 }
		attributes.addFlashAttribute("mensagem", "Equipe salvo com sucesso!!");
		// Salvar no banco de dados...
		// attributes.addFlashAttribute("mensagem", "Banco salva com sucesso!");
		// System.out.println(">>> sku: " + usuario.getClass()
		// System.out.println(">>> sku: " + banco.getNome());
		return new ModelAndView("redirect:/equipes/novo");
	}

}