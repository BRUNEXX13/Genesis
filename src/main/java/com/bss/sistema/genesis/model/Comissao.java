package com.bss.sistema.genesis.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "comissao")
public class Comissao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotBlank(message = "Descrição é obrigatório") // Nao deixa inserir nulos e espacos
	@Size(min = 1, max = 50)
	private String descricao;

	@NotBlank(message = "Descrição é obrigatório")
	private BigDecimal valorPaga;

	@NotBlank(message = "Descrição é obrigatório")
	private BigDecimal valorRecebida;

	@ManyToOne
	@JoinColumn(name = "codigo_proposta")
	private Proposta proposta;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorPaga() {
		return valorPaga;
	}

	public void setValorPaga(BigDecimal valorPaga) {
		this.valorPaga = valorPaga;
	}

	public BigDecimal getValorRecebida() {
		return valorRecebida;
	}

	public void setValorRecebida(BigDecimal valorRecebida) {
		this.valorRecebida = valorRecebida;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	
	
}
