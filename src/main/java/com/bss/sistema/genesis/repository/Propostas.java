package com.bss.sistema.genesis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bss.sistema.genesis.model.Proposta;

@Repository  // Chamando Model - Proposta Chave primaria do tipo de dado Proposta = codigo 
public interface Propostas extends JpaRepository<Proposta, Long> {

	Optional<Proposta> findByAdeIgnoreCase(String ade);
	
	// Select * from propostass = propostas.findAll();
	

}
