package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Usuario;
import com.bss.sistema.genesis.repository.Usuarios;
import com.bss.sistema.genesis.service.exception.NomeUsuarioJaCadastradoException;


@Service
public class CadastroUsuarioService {

	@Autowired
	private Usuarios usuarios;
	

	@Transactional
	public Usuario salvar(Usuario usuario) {
		Optional<Usuario> usuarioOptional = usuarios.findByNomeIgnoreCase(usuario.getNome());
		if (usuarioOptional.isPresent()) {
			throw new NomeUsuarioJaCadastradoException("Nome do banco já cadastrado");
		}

		return usuarios.saveAndFlush(usuario);
	}

}