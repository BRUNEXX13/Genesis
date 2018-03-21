package com.bss.sistema.genesis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bss.sistema.genesis.service.CadastroPropostaService;

@Configuration
@ComponentScan(basePackageClasses = CadastroPropostaService.class)
public class ServiceConfig {

}