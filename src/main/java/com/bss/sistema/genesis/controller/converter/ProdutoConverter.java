package com.bss.sistema.genesis.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Produto;

public class ProdutoConverter implements Converter<String, Produto> {

	// Convertendo Tabela Nª para String
	@Override
	public Produto convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Produto produto = new Produto();
			produto.setCodigo(Long.valueOf(codigo));
			return produto;
		}

		return null;
	}

}
