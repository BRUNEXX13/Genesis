package com.bss.sistema.genesis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "proposta") // Vou fazer referencia ao flyway //
public class Proposta implements Serializable {

	private static final long serialVersionUID = 1L;

	// Relacionamento Proposta x Produto
	@NotNull(message = "O produto é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_produto")
	private Produto produto;

	// Relacionamento Proposta x Banco
	@NotNull(message = "O banco é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_banco")
	private Banco banco;

	@NotNull(message = "A tabela é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_tabela")
	private Tabela tabela;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	// Padrao de expressao
	// @ADE
	@NotBlank(message = "A ADE é obrigatória")
	@Size(max = 50, message = "O tamanho da ADE deve estar entre 1 e 50")
	@Column(unique = true)
	private String ade;

	@NotBlank(message = "A descrição é obrigatória")
	@Size(max = 50, message = "O tamanho da  descrição deve estar entre 1 e 50")
	private String descricao;

	@NotNull(message = "A origem é obrigatório")
	@Enumerated(EnumType.STRING)
	private Origem origem;

	@NotNull(message = "O valor Parcela é obrigatório")
	@DecimalMin("0.01")
	@DecimalMax(value = "9999999.99", message = "O valor da proposta deve ser menor que R$9.999.999,99")
	private BigDecimal valorParcela;

	@NotNull(message = "O valor Total é obrigatório")
	@DecimalMin("0.01")
	@DecimalMax(value = "9999999.99", message = "O valor da proposta deve ser menor que R$9.999.999,99")
	private BigDecimal valorTotal;

	@NotNull(message = "O valor Líquido é obrigatório")
	@DecimalMin("0.01")
	@DecimalMax(value = "9999999.99", message = "O valor da proposta deve ser menor que R$9.999.999,99")
	private BigDecimal valorLiquido;

	@ManyToOne
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "proposta")
	private List<Comissao> comissoes;

	@PrePersist
	@PreUpdate
	private void prePersistUpdate() {
		descricao = descricao.toUpperCase();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Tabela getTabela() {
		return tabela;
	}

	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}

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

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
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

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Comissao> getComissoes() {
		return comissoes;
	}

	public void setComissoes(List<Comissao> comissoes) {
		this.comissoes = comissoes;
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

	public Proposta(Produto produto, Banco banco, Tabela tabela, Long codigo, String ade, String descricao,
			Origem origem, BigDecimal valorParcela, BigDecimal valorTotal, BigDecimal valorLiquido, Cliente cliente,
			List<Comissao> comissoes) {
		super();
		this.produto = produto;
		this.banco = banco;
		this.tabela = tabela;
		this.codigo = codigo;
		this.ade = ade;
		this.descricao = descricao;
		this.origem = origem;
		this.valorParcela = valorParcela;
		this.valorTotal = valorTotal;
		this.valorLiquido = valorLiquido;
		this.cliente = cliente;
		this.comissoes = comissoes;
	}

	public Proposta() {
		super();
	}
	
	

}