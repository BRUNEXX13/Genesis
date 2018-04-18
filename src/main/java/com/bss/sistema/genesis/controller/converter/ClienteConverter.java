package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Cliente;



public class ClienteConverter implements Converter<String, Cliente> {

	// Convertendo Tabela Nª para String
	@Override
	public Cliente convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Cliente cliente = new Cliente();
			cliente.setCodigo(Long.valueOf(codigo));
			return cliente;
		}

		return null;
	}

}