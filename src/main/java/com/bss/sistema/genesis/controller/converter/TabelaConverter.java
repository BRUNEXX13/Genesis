package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Tabela;

public class TabelaConverter implements Converter<String, Tabela> {

	// Convertendo Tabela Nª para String
	@Override
	public Tabela convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Tabela tabela = new Tabela();
			tabela.setCodigo(Long.valueOf(codigo));
			return tabela;
		}

		return null;
	}

}
