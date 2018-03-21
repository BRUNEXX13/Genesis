package com.bss.sistema.genesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Banco;
import com.bss.sistema.genesis.repository.Bancos;

@Service
public class CadastroBancoService {

	@Autowired
	private Bancos bancos;
	
	@Transactional
	public void salvar(Banco banco)  {
		bancos.save(banco);
	}
	
}