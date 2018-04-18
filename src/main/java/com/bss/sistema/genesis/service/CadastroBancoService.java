package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Banco;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.service.exception.NomeBancoJaCadastradoException;

@Service
public class CadastroBancoService {

	@Autowired
	private Bancos bancos;

	@Transactional
	public Banco salvar(Banco banco) {
		Optional<Banco> bancoOptional = bancos.findByNomeIgnoreCase(banco.getNome());
		if (bancoOptional.isPresent()) {
			throw new NomeBancoJaCadastradoException("Nome do banco já cadastrado");
		}

		return bancos.saveAndFlush(banco);
	}

}
