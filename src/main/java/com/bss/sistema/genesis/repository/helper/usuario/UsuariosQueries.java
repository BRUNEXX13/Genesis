package com.bss.sistema.genesis.repository.helper.usuario;

import java.util.List;

import com.bss.sistema.genesis.model.Usuario;
import com.bss.sistema.genesis.repository.filter.UsuarioFilter;

//O NOME DA INTERFACE SEMPRE NO PLURAL !!! 
public interface UsuariosQueries {
	
	public List<Usuario> filtrar (UsuarioFilter filtro);

}
