package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Tabela;
import com.bss.sistema.genesis.repository.Tabelas;
import com.bss.sistema.genesis.service.exception.NomeTabelaJaCadastradoException;

@Service
public class CadastroTabelaService {

	@Autowired
	private Tabelas tabelas;

	@Transactional
	public void salvar(Tabela tabela) {
		Optional<Tabela> tabelaOptional = tabelas.findByDescricaoIgnoreCase(tabela.getDescricao());
		if (tabelaOptional.isPresent()) {
			throw new NomeTabelaJaCadastradoException("Nome de tabela já cadastrado");
		}

		tabelas.save(tabela);

	}

}