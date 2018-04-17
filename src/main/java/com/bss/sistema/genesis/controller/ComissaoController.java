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
import com.bss.sistema.genesis.model.Origem;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.repository.Produtos;
import com.bss.sistema.genesis.repository.Propostas;
import com.bss.sistema.genesis.repository.Tabelas;
import com.bss.sistema.genesis.service.CadastroComissaoService;

@Controller
@RequestMapping("/comissoes")
public class ComissaoController {

	@Autowired
	private Bancos bancos;

	@Autowired
	private Tabelas tabelas;

	@Autowired
	private Produtos produtos;
	
	@Autowired
	private Propostas propostas;
	


	@Autowired
	private CadastroComissaoService cadastroComissaoservice;

	@RequestMapping("/novo")
	public ModelAndView novo(Comissao comissao) {
		ModelAndView mv = new ModelAndView("/comissao/CadastroComissao");
		mv.addObject("bancos", bancos.findAll());
		mv.addObject("produtos", produtos.findAll());
		mv.addObject("origens", Origem.values());
		mv.addObject("tabelas", tabelas.findAll());
		mv.addObject("propostas", propostas.findAll());

		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Comissao comissao, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println(">>> COMISSA: " + comissao.getDescricao());
			return novo(comissao);
		}

		// Salvar no banco de dados...

		cadastroComissaoservice.salvar(comissao);
		attributes.addFlashAttribute("mensagem", "Comissao Salva com sucesso!");
		
		return new ModelAndView("redirect:/comissoes/novo");
	}

}