package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Equipe;
import com.bss.sistema.genesis.repository.Equipes;
import com.bss.sistema.genesis.service.exception.NomeEquipeJaCadastradoException;

@Service
public class CadastroEquipeService {

	@Autowired
	private Equipes equipes;
	
	@Transactional
	public void salvar(Equipe equipe) {
		Optional<Equipe> EquipeOptional = equipes.findByNomeIgnoreCase(equipe.getNome());
		if(EquipeOptional.isPresent()) {
			throw new NomeEquipeJaCadastradoException("Nome da equipe já cadastrado");
		}
		equipes.save(equipe);
	}

}