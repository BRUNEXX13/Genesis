package com.bss.sistema.genesis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bss.sistema.genesis.model.Conta;

@Repository
public interface Contas extends JpaRepository<Conta, Long> {

	


	public Optional<Conta> findByTitularIgnoreCase(String titular);

}
