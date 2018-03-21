package com.bss.sistema.genesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.repository.Propostas;

@Service
public class CadastroPropostaService {

	@Autowired
	private Propostas propostas;
	
	@Transactional
	public void salvar(Proposta proposta) {
		propostas.save(proposta);
	}
	
}