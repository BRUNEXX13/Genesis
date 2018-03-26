package com.bss.sistema.genesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Comissao;
import com.bss.sistema.genesis.repository.Comissoes;

@Service
public class CadastroComissaoService {

	@Autowired
	private Comissoes comissoes;

	@Transactional
	public void salvar(Comissao comissao) {
		comissoes.save(comissao);
	}

}