package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Comissao;

public class ComissaoConverter implements Converter<String, Comissao> {

	// Convertendo Tabela Nª para String
	@Override
	public Comissao convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Comissao comissao = new Comissao();
			comissao.setCodigo(Long.valueOf(codigo));
			return comissao;
		}

		return null;
	}

}
