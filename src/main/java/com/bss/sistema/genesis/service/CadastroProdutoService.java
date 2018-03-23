package com.bss.sistema.genesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Produto;
import com.bss.sistema.genesis.repository.Produtos;

@Service
public class CadastroProdutoService {

	@Autowired
	private Produtos produtos;
	
	@Transactional
	public void salvar(Produto produto) {
		produtos.save(produto);
	}
	
}