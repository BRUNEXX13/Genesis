package com.bss.sistema.genesis.repository.filter;

import java.math.BigDecimal;

import com.bss.sistema.genesis.model.Banco;
import com.bss.sistema.genesis.model.Cliente;
import com.bss.sistema.genesis.model.Produto;
import com.bss.sistema.genesis.model.Tabela;

public class PropostaFilter {

	private String ade;
	private Cliente cliente;
	private Banco banco;
	private Produto produto;
	private Tabela tabela;
	private BigDecimal valorDe;
	private BigDecimal valorAte;
	


	public String getAde() {
		return ade;
	}

	public void setAde(String ade) {
		this.ade = ade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Tabela getTabela() {
		return tabela;
	}

	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}

	public BigDecimal getValorDe() {
		return valorDe;
	}

	public void setValorDe(BigDecimal valorDe) {
		this.valorDe = valorDe;
	}

	public BigDecimal getValorAte() {
		return valorAte;
	}

	public void setValorAte(BigDecimal valorAte) {
		this.valorAte = valorAte;
	}

}
