package com.bss.sistema.genesis.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;


//Classe de Validacoes de Mensagens 

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?")
public @interface ADE {

	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "ADE deve seguir o Padrão XX999";
	
	Class<?>[] groups()default {};
	Class<? extends Payload>[] payload() default {};
	// Payload carrega mais informacao da anotacao

}
