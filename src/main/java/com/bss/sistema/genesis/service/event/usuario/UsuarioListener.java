package com.bss.sistema.genesis.service.event.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.bss.sistema.genesis.storage.FotoStorage;

@Component
public class UsuarioListener {

	@Autowired
	private FotoStorage fotoStorage;

	@EventListener(condition = "#evento.temFoto()")
	public void usuarioSalva(UsuarioSalvaEvent evento) {
		System.out.println("Tem Foto sim" + evento.getUsuario().getFoto());
		fotoStorage.salvar(evento.getUsuario().getFoto());

	}

}
