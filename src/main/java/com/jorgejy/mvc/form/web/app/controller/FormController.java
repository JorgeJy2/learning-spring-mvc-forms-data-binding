package com.jorgejy.mvc.form.web.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jorgejy.mvc.form.web.app.models.domain.User;

@Controller
@SessionAttributes("user")
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		User user = new User();
		
		user.setName("Jorge");
		user.setFirstName("Jacobo");
		user.setId("19383D");
		model.addAttribute("user", user);
		return "form";
	}
	
	
	@PostMapping("/form")
	public String getForm(
			@RequestParam (name="username") String username,
			@RequestParam String password,
			@RequestParam String email,
			Model model) {
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		model.addAttribute("email", email);
		
		model.addAttribute("user", user);

		return "result";
	}
	// Match parameters with POJO
	@PostMapping("/form-model")
	public String getFormModel(
			@Valid User user, //@ModelAttribute("newName") // change name to view 
			BindingResult bindingResult, // result error and info validation
			Model model,
			SessionStatus sessionStatus // manager session 
			) {
		if(bindingResult.hasErrors()) {
//			Map<String, String> errors = new HashMap<String, String>();
//			bindingResult.getFieldErrors().forEach(error-> {
//				errors.put(error.getField(), "El campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
//			} );
//			model.addAttribute("error", errors);
			// Error manager automatic use thymeleaf
			return "form";
		}
		model.addAttribute("user", user);
		sessionStatus.setComplete();
		return "result";
	}
}
