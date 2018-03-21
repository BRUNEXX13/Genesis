package com.bss.sistema.genesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bss.sistema.genesis.model.Comissao;

// Chamando os Bancos em CadastroProposta no Combobox

@Repository 
public interface Comissoes extends JpaRepository<Comissao, Long> {

}
