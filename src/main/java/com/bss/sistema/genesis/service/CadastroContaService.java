package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Conta;
import com.bss.sistema.genesis.repository.Contas;
import com.bss.sistema.genesis.service.exception.NomeContaJaCadastradoException;

@Service
public class CadastroContaService {

	@Autowired
	private Contas contas;

	// Salvar e Populando no Banco de dados //
	@Transactional
	public Conta salvar(Conta conta) {
		Optional<Conta> contaOptional = contas.findByAgenciaIgnoreCase(conta.getAgencia());
		if (contaOptional.isPresent()) {
			throw new NomeContaJaCadastradoException("Nome da conta  já cadastrada !!");
		}
		 // Save And Flush salvar no Banco e Incrementar o cod
		return contas.saveAndFlush(conta);
	}

}
