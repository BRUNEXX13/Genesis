package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Proposta;

public class PropostaConverter implements Converter<String, Proposta> {

	// Convertendo Tabela Nª para String
	@Override
	public Proposta convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Proposta proposta = new Proposta();
			proposta.setCodigo(Long.valueOf(codigo));
			return proposta;
		}

		return null;
	}

}
