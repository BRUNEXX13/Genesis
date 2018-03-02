package com.bss.sistema.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "banco")
public class Banco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "banco")
	private List<Proposta> propostas;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotBlank
	private int numero;

	@NotBlank
	private String nome;

	

}
