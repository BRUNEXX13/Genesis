package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Equipe;

public class EquipeConverter implements Converter<String, Equipe> {

	// Convertendo Tabela Nª para String
	@Override
	public Equipe convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Equipe equipe = new Equipe();
			equipe.setCodigo(Long.valueOf(codigo));
			return equipe;
		}

		return null;
	}

}