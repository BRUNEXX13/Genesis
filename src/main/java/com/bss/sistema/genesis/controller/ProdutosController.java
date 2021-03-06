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
import com.bss.sistema.genesis.service.exception.NomeProdutoJaCadastradoException;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private Bancos bancos;

	@Autowired
	private CadastroProdutoService cadastroProdutoService;

	// Apontamento para Propostas
	@RequestMapping("/novo")
	public ModelAndView novo(Produto produto) { // Propost Disponivel na Requiscao
		ModelAndView mv = new ModelAndView("/produto/CadastroProduto");
		mv.addObject("tipos", Tipo.values());
		mv.addObject("bancos", bancos.findAll());
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST) // aqui é o post
	public ModelAndView cadastrar(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			// System.out.println(">>> sk: " + produto.getDescricao());
			return novo(produto);
		}
		
		try {
			cadastroProdutoService.salvar(produto);
			 } catch(NomeProdutoJaCadastradoException e) {
				 result.rejectValue("descricao", e.getMessage(), e.getMessage());
				 return novo(produto);
			 }
		attributes.addFlashAttribute("mensagem", "Produto Salvo  com sucesso!!");
		// Salvar no banco de dados...
		System.out.println(">>>Descricao " + produto.getDescricao());
		System.out.println(">>>Tipo: " + produto.getTipo());
		System.out.println(">>>>> Banco  " + produto.getBanco());
		return new ModelAndView("redirect:/produtos/novo");
	}

}
