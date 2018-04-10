package com.bss.sistema.genesis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bss.sistema.genesis.model.Produto;
import com.bss.sistema.genesis.repository.Produtos;
import com.bss.sistema.genesis.service.exception.NomeProdutoJaCadastradoException;

@Service
public class CadastroProdutoService {

	@Autowired
	private Produtos produtos;
	
	@Transactional
	public void salvar(Produto produto) {
	Optional<Produto> produtoOptional = produtos.findByDescricaoIgnoreCase(produto.getDescricao());
	if(produtoOptional.isPresent()) {
		throw new NomeProdutoJaCadastradoException("Produto do produto já cadastrado");
	}
	produtos.save(produto);
	

}
}