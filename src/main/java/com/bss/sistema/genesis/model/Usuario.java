package com.bss.sistema.genesis.model;

import java.io.Serializable;
import java.time.LocalDate;
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
import org.springframework.util.StringUtils;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
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

	@NotBlank(message = "Senha é obrigatório")
	private String senha;

	@NotBlank(message = "Confirmação de senha obrigatorio")
	private String confSenha;

	@NotBlank(message = "CPF é obrigatório")
	@Column(unique = true)
	private String cpf;

	private Boolean ativo;

	private String foto;

	@Column(name = "content_type")
	private String contentType;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@NotNull(message = "O Gênero é obrigatório")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@NotNull(message = "O grupo é obrigatório")
	@Enumerated(EnumType.STRING)
	private Grupo grupo;

	@OneToMany(mappedBy = "usuario")
	private List<Equipe> equipes;

	@NotNull(message = "A conta  é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_conta")
	private Conta conta;

	@OneToMany(mappedBy = "equipe")
	private List<Comissao> comissoes;

	@PrePersist
	@PreUpdate
	private void prePersistUpdate() {
		nome = nome.toUpperCase();
		sobrenome = sobrenome.toUpperCase();
		email = email.toUpperCase();

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getFoto() {
		return foto; 
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getFotoOuMock() {
		return !StringUtils.isEmpty(foto) ? foto : "usuario-mock.png";
	}

	
	
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
