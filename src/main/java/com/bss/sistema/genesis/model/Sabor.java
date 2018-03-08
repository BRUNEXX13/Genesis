package com.bss.sistema.genesis.model;

public enum Sabor {

	ADOCICADA("Adocicada"),
	AMARGA("Amarga"),
	FORTE("Forte"),
	FRUTADA("Frutada"),
	SUAVE("Suave");
	
	private String descricao;  
// chamando CadastroPrposta = 	<option th:each="sabor : ${sabores}" th:value="${sabor}" th:text="${sabor.descricao}">
	
	Sabor(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}