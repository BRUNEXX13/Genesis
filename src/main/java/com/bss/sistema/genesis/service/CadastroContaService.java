package com.bss.sistema.genesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Conta;
import com.bss.sistema.genesis.repository.Contas;

@Service
public class CadastroContaService {

	@Autowired
	private Contas contas;

	@Transactional
	public void salvar(Conta conta) {
		contas.save(conta);
	}

}
