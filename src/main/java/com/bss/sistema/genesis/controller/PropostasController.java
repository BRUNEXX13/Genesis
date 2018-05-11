package com.bss.sistema.genesis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bss.sistema.genesis.model.Origem;
import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.repository.Clientes;
import com.bss.sistema.genesis.repository.Produtos;
import com.bss.sistema.genesis.repository.Propostas;
import com.bss.sistema.genesis.repository.Tabelas;
import com.bss.sistema.genesis.repository.filter.PropostaFilter;
import com.bss.sistema.genesis.service.CadastroPropostaService;
import com.bss.sistema.genesis.service.exception.NomePropostaJaCadastradoException;

@Controller
@RequestMapping("/propostas")
public class PropostasController {
	
	
	
	// Para injetar o Entity Manager Usamos o @AutoWired
	

	@Autowired
	private Bancos bancos;
	
	@Autowired
	private Tabelas tabelas;
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private Clientes clientes;
	
	@Autowired
	private Propostas propostas;
	
	
	// Servicos de Propostas - Salvar - Deletar --
	@Autowired
	private CadastroPropostaService cadastroPropostaService;

	
	@RequestMapping("/novo")
	public ModelAndView novo(Proposta proposta) {
		ModelAndView mv = new ModelAndView("/proposta/CadastroProposta");
		mv.addObject("bancos",bancos.findAll());
		mv.addObject("produtos", produtos.findAll());
		mv.addObject("origens", Origem.values());
		mv.addObject("tabelas", tabelas.findAll());
		mv.addObject("clientes", clientes.findAll());
		
		return mv;
	}
	
	@RequestMapping(value = "novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Proposta proposta, BindingResult result, Model model, RedirectAttributes attributes) {
	
		if (result.hasErrors()) {
			return novo(proposta);
		}
		
		// Salvar no banco de dados...
		// si-nis-tro hahha pera ai vou dar um refresh la 
		
		try {
			cadastroPropostaService.salvar(proposta);
			
		}catch (NomePropostaJaCadastradoException e) {
			result.rejectValue("ade", e.getMessage(), e.getMessage());
			return novo(proposta);
			
		}
		attributes.addFlashAttribute("mensagem", "Proposta Salva com sucesso!");
		
		//System.out.println(">>>> codigo : "	    + proposta.getCodigo());
		//System.out.println(">>>> ade : " 		+ proposta.getAde());
		//System.out.println(">>>> descricao : " 	+ proposta.getDescricao());
		//System.out.println(">>>> origem : " 	+ proposta.getOrigem());		
		///System.out.println(">>>> parcela : " 	+ proposta.getValorParcela());
		//System.out.println(">>>> total : " 		+ proposta.getValorTotal());
		//System.out.println(">>>> liquido : " 	+ proposta.getValorLiquido());
		//System.out.println("proposta.getTabela()"+ proposta.getTabela()) ;
		//if(proposta.getTabela() !=null)
		//	System.out.println(">>>> TABELA : " 	+ proposta.getTabela().getCodigo());

		//System.out.println(">>>>>> banco :" 	+ proposta.getb
		
		
		return new ModelAndView("redirect:/propostas/novo");
	}
	
	
	@GetMapping
	public ModelAndView pesquisar(PropostaFilter propostaFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("proposta/PesquisaPropostas");
		mv.addObject("bancos",bancos.findAll());
		mv.addObject("produtos", produtos.findAll());
		mv.addObject("tabelas", tabelas.findAll());
		mv.addObject("clientes", clientes.findAll());
		mv.addObject("propostas", propostas.filtrar(propostaFilter));
		return mv;
	}
}