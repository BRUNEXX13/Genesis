package com.bss.sistema.genesis.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "proposta") // Vou fazer referencia ao flyway //
public class Proposta {

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="cd_ade")
	@NotBlank(message = "Código é obrigatório")
	private String ade;

	@Column(name="nm_descricao")
	@NotBlank(message = "Descrição é obrigatório") // Nao deixa inserir nulos e espacos
	@Size(min = 1, max = 50)
	private String descricao;

	
	@Column(name = "vl_parcela")
	private BigDecimal valorParcela;

	@Column(name = "vl_total")
	private BigDecimal valorTotal;

	@Column(name = "vl_liquido")
	private BigDecimal valorLiquido;

	@Column(name="vl_comissao")
	private BigDecimal comissao;

	@Enumerated(EnumType.STRING)
	private Sabor sabor;

	@ManyToOne /// Uma proposta tem um Banco // Um Banco tem varias propostas
	@JoinColumn(name = "codigo_banco")
	private Banco banco;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getAde() {
		return ade;
	}

	public void setAde(String ade) {
		this.ade = ade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	
	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Proposta other = (Proposta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}