package com.bss.sistema.genesis.service.event.usuario;

import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Usuario;

public class UsuarioSalvaEvent {

	private Usuario usuario;

	public UsuarioSalvaEvent(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	//Metodo para verifica se tem foto ou nao refeencia no UsuarioLstener
	public boolean temFoto() {
		return !StringUtils.isEmpty(usuario.getFoto());
	}

}
