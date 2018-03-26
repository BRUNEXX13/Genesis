package com.bss.sistema.genesis.model;

public enum Grupo {
	
	ADMINISTRADOR("Administrador"),
	GERENTE("Gerente"),
	SUPERVISOR("Supervisor"),
	ASSESSOR("Assessor");
	
	private String descricao;
	
	Grupo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
