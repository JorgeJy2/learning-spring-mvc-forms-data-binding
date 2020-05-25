package com.jorgejy.mvc.form.web.app.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IdentifierValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdentifierRegex {
	String message() default "ID no válido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
