package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Usuario;
import com.bss.sistema.genesis.repository.Usuarios;
import com.bss.sistema.genesis.service.event.usuario.UsuarioSalvaEvent;
import com.bss.sistema.genesis.service.exception.NomeUsuarioJaCadastradoException;

@Service
public class CadastroUsuarioService {

	@Autowired
	private Usuarios usuarios;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Transactional
	public void salvar(Usuario usuario) {
		Optional<Usuario> usuarioOptional = usuarios.findByNomeIgnoreCase(usuario.getNome());
		if (usuarioOptional.isPresent()) {
			throw new NomeUsuarioJaCadastradoException("Nome do banco já cadastrado");
		}

		usuarios.save(usuario);
		publisher.publishEvent(new UsuarioSalvaEvent(usuario));
	}

}