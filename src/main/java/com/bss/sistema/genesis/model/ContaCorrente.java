package com.bss.sistema.genesis.model;

import java.io.Serializable;

public class ContaCorrente  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigconta;
	private int numero;
	private String agencia;
	private String titular;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(int codigconta, int numero, String agencia, String titular) {
		super();
		this.codigconta = codigconta;
		this.numero = numero;
		this.agencia = agencia;
		this.titular = titular;
	}

	public int getCodigconta() {
		return codigconta;
	}

	public void setCodigconta(int codigconta) {
		this.codigconta = codigconta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
