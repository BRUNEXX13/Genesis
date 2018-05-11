package com.bss.sistema.genesis.repository.helper.proposta;

import java.util.List;

import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.repository.filter.PropostaFilter;

// O NOME DA INTERFACE SEMPRE NO PLURAL !!!  SE NAO NAO ACHA NA CONTROLLER
public interface PropostasQueries {

	public List<Proposta> filtrar (PropostaFilter filtro);

}
