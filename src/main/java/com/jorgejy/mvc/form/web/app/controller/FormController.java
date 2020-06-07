package com.jorgejy.mvc.form.web.app.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jorgejy.mvc.form.web.app.editors.CountryPropertyEditor;
import com.jorgejy.mvc.form.web.app.editors.NameUpperCaseEditor;
import com.jorgejy.mvc.form.web.app.models.domain.Country;
import com.jorgejy.mvc.form.web.app.models.domain.User;
import com.jorgejy.mvc.form.web.app.services.CountryService;
import com.jorgejy.mvc.form.web.app.validators.UserValidator;

@Controller
@SessionAttributes("user")
public class FormController {

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CountryPropertyEditor countryPropertyEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false); // strict
		// all fields date
		binder.registerCustomEditor(Date.class,"birthday" , new CustomDateEditor(dateFormat, true));
		// binder.registerCustomEditor(String.class,new NameUpperCaseEditor());
		
		binder.registerCustomEditor(String.class,"name",new NameUpperCaseEditor());
		
		binder.registerCustomEditor(Country.class,"country",countryPropertyEditor);
		
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		User user = new User();
		user.setId("19.383.233-D");
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
		// userValidator.validate(user, bindingResult);
		
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
	
	@ModelAttribute("countries")
	public List<String> countries(){
		return Arrays.asList("México","España","Chile", "Perú");
	}
	
	@ModelAttribute("listCountries")
	public List<Country> listCountries(){
		return countryService.list();
	}
	
	@ModelAttribute("mapCountries")
	public Map<String, String> mapCountries(){
		Map<String, String> countries = new HashMap<String, String>();
		countries.put("ES", "España");
		countries.put("MX", "México");
		countries.put("CL", "Chile");
		countries.put("AR", "Perú");
		countries.put("CO", "Colombia");
		return countries;
		
	}
}
