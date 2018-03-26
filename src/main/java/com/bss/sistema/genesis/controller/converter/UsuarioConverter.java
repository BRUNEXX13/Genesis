package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Usuario;

public class UsuarioConverter implements Converter<String, Usuario> {

	// Convertendo Tabela Nª para String
	@Override
	public Usuario convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Usuario usuario = new Usuario();
			usuario.setCodigo(Long.valueOf(codigo));
			return usuario;
		}

		return null;
	}

}
