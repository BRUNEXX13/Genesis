package com.bss.sistema.genesis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

// novo
// cartao
// refinanciamento
// portabilidade

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@NotBlank(message = "Descrição é obrigatório") // Nao deixa inserir nulos e espacos
	@Size(min = 1, max = 100)
	private String descricao;

	@NotBlank(message = "Descrição é obrigatório") // Nao deixa inserir nulos e espacos
	@Size(min = 1, max = 100)
	private String tipo;
	
	@ManyToOne /// Uma proposta tem um Banco // Um Banco tem varias propostas
	@JoinColumn(name = "codigo_banco")
	private Banco banco;
	
	

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Produto(long codigo, String descricao, String tipo) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public Produto() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo != other.codigo)	
			return false;
		return true;
	}

}
