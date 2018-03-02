package com.bss.sistema.genesis.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bss.sistema.genesis.config.JPAConfig;
import com.bss.sistema.genesis.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override   // 1º Root Configurado // Beans Congfigurados aqui sao disponibilizados para Serverlet
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {JPAConfig.class};
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
}