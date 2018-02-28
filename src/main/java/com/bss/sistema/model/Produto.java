package com.bss.sistema.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Produto {

	@NotNull
	private int cdproduto;
	
	@NotBlank
	private String nome;
	
	//novo
	//cartao
	//refinanciamento
	//portabilidade 

	public int getCdproduto() {
		return cdproduto;
	}

	public void setCdproduto(int cdproduto) {
		this.cdproduto = cdproduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Produto(int cdproduto, String nome) {
		super();
		this.cdproduto = cdproduto;
		this.nome = nome;
	}

	public Produto() {
		super();
	}
	

	
	
}
