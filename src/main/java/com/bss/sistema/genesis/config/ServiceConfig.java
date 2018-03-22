package com.bss.sistema.genesis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bss.sistema.genesis.service.CadastroBancoService;
import com.bss.sistema.genesis.service.CadastroPropostaService;



@Configuration					   // Nessa Classe e procurada os services
@ComponentScan(basePackageClasses = CadastroBancoService.class)
@ComponentScan(basePackageClasses = CadastroPropostaService.class)
public class ServiceConfig {

}