package com.bss.sistema.genesis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bss.sistema.genesis.model.Cliente;

@Repository
public interface Clientes extends JpaRepository<Cliente, Long>  {
	
	
	public Optional<Cliente> findByNomeIgnoreCase(String nome) ;

}
