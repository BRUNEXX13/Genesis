package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;

import com.bss.sistema.genesis.model.Banco;

public class BancoConverter implements Converter<String, Banco> {

	@Override
	public Banco convert(String codigo) {
		Banco banco = new Banco();
		banco.setCodigo(Long.valueOf(codigo));
		return banco;
	}

}
