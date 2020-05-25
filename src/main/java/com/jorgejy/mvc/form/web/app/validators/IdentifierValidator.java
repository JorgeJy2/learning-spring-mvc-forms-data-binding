package com.jorgejy.mvc.form.web.app.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentifierValidator implements ConstraintValidator<IdentifierRegex, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return (value.matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}"));
	}

}
