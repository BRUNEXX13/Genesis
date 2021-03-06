
/*
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

import com.bss.sistema.genesis.model.Comissao;
import com.bss.sistema.genesis.repository.Comissoes;
import com.bss.sistema.genesis.repository.Equipes;
import com.bss.sistema.genesis.repository.Propostas;
import com.bss.sistema.genesis.service.CadastroComissaoService;

@Controller
public class ComissaoController {

	@Autowired
	private Equipes equipes;

	@Autowired
	private Propostas propostas;

	@Autowired
	private Comissoes comissoes;

	@Autowired
	private CadastroComissaoService cadastroComissaoService;

	@RequestMapping("comissoes/novo")
	public ModelAndView novo(Comissao comissao) {
		ModelAndView mv = new ModelAndView("/comissao/CadastroComissao");
		mv.addObject("equipes", equipes.findAll());
		mv.addObject("propostas", propostas.findAll());
		return mv;
	}

	@RequestMapping(value = "/comissoes/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Comissao comissao, BindingResult result, Model Model,RedirectAttributes attributes) {

		attributes.addFlashAttribute("mensagem", "Comissao Salva com Sucesso");
		System.out.println(">>>>>>>>COMISSAO" + comissao.getVlComissao());
		System.out.println(" >>>>>>>DESCRICAO" + comissao.getDescricao());
		System.out.println(" >>>>>>>DESCRICAO" + comissao.getBonus());
		System.out.println(" >>>>>>>EQUIPE" + comissao.getEquipe());
		System.out.println(" >>>>>>>PROPOSTA" + comissao.getProposta());

		return new ModelAndView("redirect:/comissoes/novo");

	}

}
*/
