package com.bss.sistema.genesis.config;

import java.math.BigDecimal;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.bss.sistema.genesis.controller.PropostasController;
import com.bss.sistema.genesis.controller.converter.BancoConverter;
import com.bss.sistema.genesis.controller.converter.ClienteConverter;
import com.bss.sistema.genesis.controller.converter.ComissaoConverter;
import com.bss.sistema.genesis.controller.converter.ContaConverter;
import com.bss.sistema.genesis.controller.converter.EquipeConverter;
import com.bss.sistema.genesis.controller.converter.ProdutoConverter;
import com.bss.sistema.genesis.controller.converter.PropostaConverter;
import com.bss.sistema.genesis.controller.converter.TabelaConverter;
import com.bss.sistema.genesis.controller.converter.UsuarioConverter;
import com.bss.sistema.genesis.thymeleaf.GenesisDialect;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@ComponentScan(basePackageClasses = { PropostasController.class })
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}

	// Adicionado Layout Dialect// Thymeleaf Layout Dialect =
	// nz.net.ultraqTyhmeleafDialect
	@Bean
	public TemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());

		engine.addDialect(new LayoutDialect());
		engine.addDialect(new GenesisDialect());
		return engine;
	}

	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}

	// Indicando onde procurar recursos Estaticos = js, css etc //
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

	}

	// Conversion Service, Convertando o dados Int para String De Tabela na Tela
	// Proposta
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

		// Adicionando os Conversores ///

		conversionService.addConverter(new ComissaoConverter());
		conversionService.addConverter(new TabelaConverter());
		conversionService.addConverter(new BancoConverter());
		conversionService.addConverter(new ProdutoConverter());
		conversionService.addConverter(new PropostaConverter());
		conversionService.addConverter(new EquipeConverter());
		conversionService.addConverter(new UsuarioConverter());
		conversionService.addConverter(new ContaConverter());
		conversionService.addConverter(new ClienteConverter());
		conversionService.addConverter(new ClienteConverter());
		
		
		
		// Convertendo os numeros para casas decimais
		NumberStyleFormatter bigDecimalFormatter = new NumberStyleFormatter("#,##0.00");
		conversionService.addFormatterForFieldType(BigDecimal.class, bigDecimalFormatter);

		NumberStyleFormatter integerFormatter = new NumberStyleFormatter("#,##0");
		conversionService.addFormatterForFieldType(Integer.class, integerFormatter);

		return conversionService;
	}

	// Fixando o Pais de Origem // Independe do Browser, vai tratar no formato BR
	// Browser//
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

}
