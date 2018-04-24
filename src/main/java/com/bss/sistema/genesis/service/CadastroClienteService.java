package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Cliente;
import com.bss.sistema.genesis.repository.Clientes;
import com.bss.sistema.genesis.service.exception.NomeClienteJaCadastradoException;

@Service
public class CadastroClienteService {
	
	@Autowired
	private Clientes clientes;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		Optional<Cliente> clienteOptional = clientes.findByNomeIgnoreCase(cliente.getNome());
		if (clienteOptional.isPresent()) {
			throw new NomeClienteJaCadastradoException("Nome do Cliente já cadastrado");
		}

		return clientes.saveAndFlush(cliente);
	}

}
