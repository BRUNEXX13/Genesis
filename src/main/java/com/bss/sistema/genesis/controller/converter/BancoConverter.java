package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Banco;


public class BancoConverter implements Converter<String, Banco> {

	// Convertendo Tabela Nª para String
	@Override
	public Banco convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Banco banco  = new Banco ();
			banco.setCodigo(Long.valueOf(codigo));
			return banco;
		}

		return null;
	}

}
