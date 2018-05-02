package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Banco;
import com.bss.sistema.genesis.repository.Bancos;
import com.bss.sistema.genesis.service.exception.NomeBancoJaCadastradoException;
import com.bss.sistema.genesis.service.exception.NumeroBancoJacadastradoException;

@Service
public class CadastroBancoService {

	@Autowired
	private Bancos bancos;

	/// Verificar a validacao de Numero e Banco // -- IMPORTANTE --
		@Transactional
		public Banco salvar(Banco banco)  {
			
			Optional<Banco> bancoOptional = bancos.findByNumeroAndNomeIgnoreCase(banco.getNumero(), banco.getNome());
			if (bancoOptional.isPresent()) {
				throw new  NumeroBancoJacadastradoException("Número do Banco já cadastrado");
			}
			if (bancoOptional.isPresent()) {
				throw new NomeBancoJaCadastradoException("Nome do banco ja cadastrado !***");

			}

			return bancos.saveAndFlush(banco);
		}
		
		
}
