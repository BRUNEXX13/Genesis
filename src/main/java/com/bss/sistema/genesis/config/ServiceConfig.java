package com.bss.sistema.genesis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bss.sistema.genesis.service.CadastroBancoService;
import com.bss.sistema.genesis.service.CadastroClienteService;
import com.bss.sistema.genesis.service.CadastroComissaoService;
import com.bss.sistema.genesis.service.CadastroContaService;
import com.bss.sistema.genesis.service.CadastroEquipeService;
import com.bss.sistema.genesis.service.CadastroProdutoService;
import com.bss.sistema.genesis.service.CadastroPropostaService;
import com.bss.sistema.genesis.service.CadastroTabelaService;
import com.bss.sistema.genesis.service.CadastroUsuarioService;
import com.bss.sistema.genesis.storage.FotoStorage;
import com.bss.sistema.genesis.storage.local.FotoStorageLocal;

 // Nessa Classe e procurada os services // Componente Scan verifica cada Classe
				// Service

@Configuration
@ComponentScan(basePackageClasses = CadastroComissaoService.class)
@ComponentScan(basePackageClasses = CadastroEquipeService.class)
@ComponentScan(basePackageClasses = CadastroTabelaService.class)
@ComponentScan(basePackageClasses = CadastroProdutoService.class)
@ComponentScan(basePackageClasses = CadastroBancoService.class)
@ComponentScan(basePackageClasses = CadastroPropostaService.class)
@ComponentScan(basePackageClasses = CadastroUsuarioService.class)
@ComponentScan(basePackageClasses = CadastroContaService.class)
@ComponentScan(basePackageClasses = CadastroClienteService.class)
@ComponentScan(basePackageClasses = FotoStorage.class)
    // Nessa Classe e procurada os services // Componente Scan verifica cada Classe
public class ServiceConfig {

	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}
	


}