package com.bss.sistema.genesis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bss.sistema.genesis.model.Usuario;

// Chamando os Bancos em CadastroProposta no Combobox

@Repository 
public interface Usuarios extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByNomeIgnoreCase(String nome) ;

}
