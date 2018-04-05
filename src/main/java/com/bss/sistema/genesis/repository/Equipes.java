package com.bss.sistema.genesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bss.sistema.genesis.model.Equipe;

@Repository 
public interface Equipes extends JpaRepository<Equipe, Long> {

}