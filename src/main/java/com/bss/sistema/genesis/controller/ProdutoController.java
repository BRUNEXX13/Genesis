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

import com.bss.sistema.genesis.model.Produto;
import com.bss.sistema.genesis.model.Tipo;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.service.CadastroProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private Bancos bancos;

	@Autowired
	private CadastroProdutoService cadastroProdutoService;

	// Apontamento para Propostas
	@RequestMapping("/propostas/produto/novo")
	public ModelAndView novo(Produto produto) { // Propost Disponivel na Requiscao
		ModelAndView mv = new ModelAndView("/produto/CadastroProduto");
		mv.addObject("tipos", Tipo.values());
		mv.addObject("bancos", bancos.findAll());
		return mv;
	}

	@RequestMapping(value = "/produtos/novo", method = RequestMethod.POST) // aqui é o post
	public ModelAndView cadastrar(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			// System.out.println(">>> sk: " + produto.getDescricao());
			return novo(produto);
		}
		cadastroProdutoService.salvar(produto);
		attributes.addFlashAttribute("mensagem", "Produto Salvo  com sucesso!!");
		// Salvar no banco de dados...
		System.out.println(">>>Descricao " + produto.getDescricao());
		System.out.println(">>>Tipo: " + produto.getTipo());
		System.out.println(">>>>> Banco  " + produto.getBanco());
		return new ModelAndView("redirect:/propostas/produto/novo");
	}

}
