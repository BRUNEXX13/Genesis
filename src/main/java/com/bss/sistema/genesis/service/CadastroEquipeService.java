package com.bss.sistema.genesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Equipe;
import com.bss.sistema.genesis.repository.Equipes;

@Service
public class CadastroEquipeService {

	@Autowired
	private Equipes equipes;
	
	@Transactional
	public void salvar(Equipe equipe) {
		equipes.save(equipe);
	}

}