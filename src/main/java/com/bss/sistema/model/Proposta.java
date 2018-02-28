package com.bss.sistema.model;

import java.util.Calendar;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Proposta {

	@NotBlank
	private int id;

	@NotBlank(message = "Código é obrigatório")
	private String codigo;

	private String cliente;

	@NotBlank(message = "Descrição é obrigatório") // Nao deixa inserir nulos e espacos
	@Size(min = 1, max = 50)
	private String descricao;

	@NotBlank
	private Calendar data;

	@NotBlank
	private double valorParcela;

	@NotBlank
	private double valorTotal;

	public Proposta() {
		super();
	}

	public Proposta(int id, String codigo, String cliente, String descricao, Calendar data, double valorParcela,
			double valorTotal) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cliente = cliente;
		this.descricao = descricao;
		this.data = data;
		this.valorParcela = valorParcela;
		this.valorTotal = valorTotal;
	}

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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
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

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}