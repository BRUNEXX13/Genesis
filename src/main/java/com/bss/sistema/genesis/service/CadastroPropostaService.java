package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.repository.Propostas;
import com.bss.sistema.genesis.service.exception.NomePropostaJaCadastradoException;

@Service
public class CadastroPropostaService {

	@Autowired
	private Propostas propostas;
	

	

	@Transactional
	public void salvar(Proposta proposta) {
		Optional<Proposta> propostaOptional = propostas.findByAdeIgnoreCase(proposta.getAde());
		if(propostaOptional.isPresent()) {
			throw new NomePropostaJaCadastradoException("ADE já cadastrado");
		}
		propostas.save(proposta);	


	}
}