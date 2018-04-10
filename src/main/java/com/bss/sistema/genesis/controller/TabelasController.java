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

import com.bss.sistema.genesis.model.Tabela;
import com.bss.sistema.genesis.model.Tipo;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.repository.Produtos;
import com.bss.sistema.genesis.service.CadastroTabelaService;
import com.bss.sistema.genesis.service.exception.NomeTabelaJaCadastradoException;

@Controller
public class TabelasController {

	@Autowired
	private Bancos bancos;

	@Autowired
	private Produtos produtos;

	@Autowired
	private CadastroTabelaService cadastroTabelaService;

	// Apontamento para Propostas
	@RequestMapping("/propostas/tabela/novo")
	public ModelAndView novo(Tabela tabela) { // Propost Disponivel na Requiscao
		ModelAndView mv = new ModelAndView("/tabela/CadastroTabela");
		mv.addObject("bancos", bancos.findAll());
		mv.addObject("produtos", produtos.findAll());
		mv.addObject("tipos", Tipo.values());
		return mv;
	}

	@RequestMapping(value = "/tabelas/novo", method = RequestMethod.POST) // aqui é o post
	public ModelAndView cadastrar(@Valid Tabela tabela, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println(">>> TATA: " + tabela.getDescricao());
			return novo(tabela);
		}
		try {
			cadastroTabelaService.salvar(tabela);
			 } catch(NomeTabelaJaCadastradoException e) {
				 result.rejectValue("descricao", e.getMessage(), e.getMessage());
				 return novo(tabela);
			 }
		attributes.addFlashAttribute("mensagem", "Tabela Salva com sucesso!!");
		// Salvar no banco de dados...
		// System.out.println(">>>Descricao " + produto.getDescricao());
		System.out.println(">>>TABELA 1: " + tabela.getDescricao());
		// System.out.println(">>>>> Banco " + produto.getBanco());
		return new ModelAndView("redirect:/propostas/tabela/novo");
	}

}
