package com.bss.sistema.genesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Tabela;
import com.bss.sistema.genesis.repository.Tabelas;

@Service
public class CadastroTabelaService {

	@Autowired
	private Tabelas tabelas;

	@Transactional
	public void salvar(Tabela tabela) {
		tabelas.save(tabela);
	}

}