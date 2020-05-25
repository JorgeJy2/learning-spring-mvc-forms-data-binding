package com.jorgejy.mvc.form.web.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jorgejy.mvc.form.web.app.models.domain.User;
@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		User user = (User) target;
		// 2 name field, 3 name
		//ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.user.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.user.name");
		
//		if(user.getName().isEmpty()) {
//			errors.rejectValue("name", "NotEmpty.user.name");
//		} 
		
//		if(!user.getId().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
//			errors.rejectValue("id", "Pattern.user.id");
//		 } 
	}

}
