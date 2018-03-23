package com.bss.sistema.genesis.model;

public enum Tipo {

	NOVO("Novo"), 
	REFINANCEAMENTO("Refinanceamento"),
	CARTAO("Cartão");

	private String descricao;

	Tipo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
