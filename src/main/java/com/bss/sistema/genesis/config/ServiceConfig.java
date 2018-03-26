package com.bss.sistema.genesis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bss.sistema.genesis.service.CadastroBancoService;
import com.bss.sistema.genesis.service.CadastroComissaoService;
import com.bss.sistema.genesis.service.CadastroProdutoService;
import com.bss.sistema.genesis.service.CadastroPropostaService;
import com.bss.sistema.genesis.service.CadastroTabelaService;
import com.bss.sistema.genesis.service.CadastroUsuarioService;



@Configuration // Nessa Classe e procurada os services

@ComponentScan(basePackageClasses = CadastroComissaoService.class)
@ComponentScan(basePackageClasses = CadastroTabelaService.class)
@ComponentScan(basePackageClasses = CadastroProdutoService.class)
@ComponentScan(basePackageClasses = CadastroBancoService.class)
@ComponentScan(basePackageClasses = CadastroPropostaService.class)
@ComponentScan(basePackageClasses = CadastroUsuarioService.class)

public class ServiceConfig {

}