package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;

import com.bss.sistema.genesis.model.Conta;
import org.springframework.util.StringUtils;

public class ContaConverter implements Converter<String, Conta> {

	// Convertendo Tabela Nª para String
	@Override
	public Conta convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Conta conta = new Conta();
			conta.setCodigo(Long.valueOf(codigo));
			return conta;
		}

		return null;
	}

}
