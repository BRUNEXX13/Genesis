package com.bss.sistema.genesis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bss.sistema.genesis.service.CadastroBancoService;
import com.bss.sistema.genesis.service.CadastroPropostaService;

// Aqui eu adicionei tambem o CadastroBancoService esta correto ne ?
// ja lhe mostro o mapping
// acho q não precisa. Esse basePackageClasses quer dizer pro Spring escanear no pacote base da classe. Ou seja, vai escanear o pacote todo
// certo vou apagar e testa 1 seg
// ACho que precisa passar todos nao? pq ele se referencia aqui



@Configuration					   // Nessa Classe e procurada os services
@ComponentScan(basePackageClasses = CadastroBancoService.class)
@ComponentScan(basePackageClasses = CadastroPropostaService.class)
public class ServiceConfig {

}