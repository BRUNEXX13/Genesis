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

import com.bss.sistema.genesis.model.Genero;
import com.bss.sistema.genesis.model.Grupo;
import com.bss.sistema.genesis.model.TipoConta;
import com.bss.sistema.genesis.model.Usuario;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.repository.Contas;
import com.bss.sistema.genesis.repository.Equipes;
import com.bss.sistema.genesis.repository.Usuarios;
import com.bss.sistema.genesis.repository.filter.UsuarioFilter;
import com.bss.sistema.genesis.service.CadastroUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	// Para injetar o Entity Manager Usamos o @AutoWired
	
	
	@Autowired
	private Contas contas;

	@Autowired
	private Bancos bancos;

	@Autowired
	private Equipes equipes;

	@Autowired
	private Usuarios usuarios;

	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;

	// Apontamento para Usuarios
	@RequestMapping("/novo") //
	public ModelAndView novo(Usuario usuario) { //
		ModelAndView mv = new ModelAndView("/usuario/CadastroUsuario");
		mv.addObject("generos", Genero.values());
		mv.addObject("grupos", Grupo.values());
		mv.addObject("contas", contas.findAll());
		mv.addObject("bancos", bancos.findAll());
		mv.addObject("tipos", TipoConta.values());
		mv.addObject("equipes", equipes.findAll());

		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST) // aqui é o post
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			// System.out.println(">>> sku: " + banco.getNumero());
			return novo(usuario);
		}
		cadastroUsuarioService.salvar(usuario);
		attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso!!");
		// Salvar no banco de dados...
		// attributes.addFlashAttribute("mensagem", "Banco salva com sucesso!");
		// System.out.println(">>> sku: " + usuario.getClass()
		// System.out.println(">>> sku: " + banco.getNome());
		return new ModelAndView("redirect:/usuarios/novo");
	}

	// Disponobilizando a Pesquisa de Usuarios

	//// @GetMapping
	// public ModelAndView pesquisar(UsuarioFilter usuarioFilter, BindingResult
	//// result)

	// {

	// ModelAndView mv = new ModelAndView("usuario/PesquisaUsuarios");
	// mv.addObject("contas", contas.findAll());
	// mv.addObject("grupos", Grupo.values());
	// mv.addObject("usuarios", usuarios.findAll());
	// return mv;
	// }

	@GetMapping
	public ModelAndView pesquisar(UsuarioFilter usuarioFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("usuario/PesquisaUsuarios");
		mv.addObject("contas", contas.findAll());
		mv.addObject("grupos", Grupo.values());
		mv.addObject("usuarios", usuarios.filtrar(usuarioFilter));
		return mv;
	}

}