package com.bss.sistema.model;

import java.util.Calendar;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


public class Proposta {

	private int id;

	@NotBlank (message = "Código é obrigatório")
	private String codigo;

	@NotBlank(message = "Descrição é obrigatório") // Nao deixa inserir nulos e espacos
	@Size(min = 1, max = 50)
	private String descricao;

	private Calendar data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Proposta(int id, String codigo, String descricao, Calendar data) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.data = data;
	}

	public Proposta() {
		super();
	}

}
