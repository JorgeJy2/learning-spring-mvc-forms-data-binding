package com.jorgejy.mvc.form.web.app.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class RequiredValidator implements ConstraintValidator<Required, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// value.isBlank() || value.isEmpty() or 
		return (value!= null && StringUtils.hasText(value));
	}

}
