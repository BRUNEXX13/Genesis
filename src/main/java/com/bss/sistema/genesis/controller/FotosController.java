package com.bss.sistema.genesis.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// Classe Controller trabalhando com AJAX // CLASSE SIMPLES 
// NA RESPOSTA DELA SERA A @RESPONS BODY//
@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	@PostMapping // Veio na Versao 4.3 do Spring
	public String upload(@RequestParam("files[]") MultipartFile[] files) {
		System.out.println(">>>>> files:" + files[0].getSize());
		return "OK!";
	}

}
