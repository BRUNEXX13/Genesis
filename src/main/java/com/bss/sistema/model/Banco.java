package com.bss.sistema.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Banco {

	@NotNull
	private int id;
	
	@NotBlank
	private int numero;
	
	@NotBlank
	private String nome;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Banco(int id, int numero, String nome) {
		super();
		this.id = id;
		this.numero = numero;
		this.nome = nome;
	}

	public Banco() {
		super();
	}

}
