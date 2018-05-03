package com.bss.sistema.genesis.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.bss.sistema.genesis.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import com.bss.sistema.genesis.thymeleaf.processor.MessageElementTagProcessor;

public class GenesisDialect extends AbstractProcessorDialect {

	public GenesisDialect() {
		super("Systems Genesis", "genesis", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		return processadores;
	}

}