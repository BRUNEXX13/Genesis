package com.bss.sistema.genesis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tabela")
public class Tabela implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "tabela")
	private List<Proposta> propostas;
	
	
	@ManyToOne
	@JoinColumn(name = "codigo_produto")
	private Produto produto;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	

	@NotBlank(message = "Descrição é obrigatório") // Nao deixa inserir nulos e espacos
	@Size(min = 1, max = 50)
	private String descricao;



	private BigDecimal coeficiente;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	

	public BigDecimal getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(BigDecimal coeficiente) {
		this.coeficiente = coeficiente;
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
		Tabela other = (Tabela) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}