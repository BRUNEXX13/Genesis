package com.bss.sistema.genesis.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long codigo;

	@NotBlank(message = "Nome é obrigatório")
	@Size(max = 50, message = "O tamanho da  descrição deve estar entre 1 e 50")
	private String nome;

	@NotBlank(message = "Sobrenome obrigatório")
	@Size(max = 50, message = "O tamanho da  descrição deve estar entre 1 e 50")
	private String sobrenome;

	@NotBlank(message = "Email é obrigatorio")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Telefone é obrigatorio")
	private String telefone;

	@NotBlank(message = "CPF é obrigatório")
	@Column(unique = true)
	private String cpf;

	@NotBlank(message = "CPF é obrigatório")
	private String rg;

	@OneToMany(mappedBy = "usuario")
	private List<Equipe> equipes;

	@Enumerated(EnumType.STRING)
	private Genero genero;

	@NotNull(message = "A conta  é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_conta")
	private Conta conta;

	@OneToMany(mappedBy = "cliente")
	private List<Proposta> propostas;

	
	@PrePersist
	@PreUpdate
	private void prePersistUpdate() {
		nome = nome.toUpperCase();
		sobrenome = sobrenome.toUpperCase();
		email 	= email.toUpperCase();
	}

	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Proposta> getPropostas() {
		return propostas;
	}

	public void setPropostas(List<Proposta> propostas) {
		this.propostas = propostas;
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Cliente(Long codigo, String nome, String sobrenome, String email, String telefone, String cpf, String rg,
			List<Equipe> equipes, Genero genero, Conta conta, List<Proposta> propostas) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rg = rg;
		this.equipes = equipes;
		this.genero = genero;
		this.conta = conta;
		this.propostas = propostas;
	}

	public Cliente() {
		super();
	}

}
