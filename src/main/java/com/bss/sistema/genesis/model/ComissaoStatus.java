package com.bss.sistema.genesis.model;

public enum ComissaoStatus {

	PAGA("Paga"), RECEBIDA("Recebida");

	private String statuscomissao;

	ComissaoStatus(String statuscomissao) {
		this.statuscomissao = statuscomissao;
	}

	public String getStatuscomissao() {
		return statuscomissao;

	}

}
