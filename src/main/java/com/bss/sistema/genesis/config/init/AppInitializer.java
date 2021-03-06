package com.bss.sistema.genesis.config.init;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

//Configuracoes da Aplicacaos

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bss.sistema.genesis.config.JPAConfig;
import com.bss.sistema.genesis.config.ServiceConfig;
import com.bss.sistema.genesis.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override   // 1º Root Configurado // Beans Congfigurados aqui sao disponibilizados para Serverlet
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {JPAConfig.class , ServiceConfig.class};
		                                            // Classa Em ServiceConfg - 
	}
	

	@Override   // 2º  O que é de Web configurado em Serveletconfig --
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	
	// Filtro Novo para Encoding Caracther UTF-8//
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);

		return new Filter[] { characterEncodingFilter };

	}
	
	// Receberr varios tipos de arquivos // JPG/ JPEG //PNG // MultipartConfigConfigElement // CL14.3
	@Override
	protected void customizeRegistration(Dynamic registration) {
	registration.setMultipartConfig(new MultipartConfigElement(""));
	
	
	}
}