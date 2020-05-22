package com.jorgejy.mvc.form.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jorgejy.mvc.form.web.app.models.domain.User;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
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
			User user,
			Model model) {
		
		model.addAttribute("user", user);

		return "result";
	}
}
