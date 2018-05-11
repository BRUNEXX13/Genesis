package com.bss.sistema.genesis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bss.sistema.genesis.model.Usuario;
import com.bss.sistema.genesis.repository.helper.usuario.UsuariosQueries;


// Chamando os Bancos em CadastroProposta no Combobox

@Repository 
public interface Usuarios extends JpaRepository<Usuario, Long> , UsuariosQueries{

	public Optional<Usuario> findByNomeIgnoreCase(String nome) ;

	



}
