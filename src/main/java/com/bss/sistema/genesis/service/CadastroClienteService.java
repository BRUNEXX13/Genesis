package com.bss.sistema.genesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Cliente;
import com.bss.sistema.genesis.repository.Clientes;

@Service
public class CadastroClienteService {
	
	@Autowired
	private Clientes clientes;
	
	@Transactional
	public void salvar(Cliente cliente) {
		clientes.save(cliente);
	}

}
