package com.bss.sistema.genesis.model;

public enum TipoConta {

	CORRENTE("Conta Corrente"), 
	POUPANCA("Poupança");

	private String descricao;

	TipoConta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
