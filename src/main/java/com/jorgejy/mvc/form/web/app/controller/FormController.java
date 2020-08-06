package com.jorgejy.mvc.form.web.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jorgejy.mvc.form.web.app.editors.CountryPropertyEditor;
import com.jorgejy.mvc.form.web.app.editors.NameUpperCaseEditor;
import com.jorgejy.mvc.form.web.app.editors.RolPropertyEditor;
import com.jorgejy.mvc.form.web.app.models.domain.Country;
import com.jorgejy.mvc.form.web.app.models.domain.Rol;
import com.jorgejy.mvc.form.web.app.models.domain.User;
import com.jorgejy.mvc.form.web.app.services.CountryService;
import com.jorgejy.mvc.form.web.app.services.RolService;
import com.jorgejy.mvc.form.web.app.validators.UserValidator;

@Controller
@SessionAttributes("user")
public class FormController {

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private CountryPropertyEditor countryPropertyEditor;
	
	@Autowired
	private RolPropertyEditor rolPropertyEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false); // strict
		// all fields date
		binder.registerCustomEditor(Date.class,"birthday" , new CustomDateEditor(dateFormat, true));
		// binder.registerCustomEditor(String.class,new NameUpperCaseEditor());
		
		binder.registerCustomEditor(String.class,"name",new NameUpperCaseEditor());
		
		binder.registerCustomEditor(Country.class, "country",countryPropertyEditor);
		binder.registerCustomEditor(Rol.class,     "roles",rolPropertyEditor);
		
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		User user = new User();
		user.setId("19.383.233-D");
		user.setName("JOrge Jacobo");
		user.setEnable(true);
		user.setSecretValue("Value secret ******");
		
		//DEFAULT VALUES COUNTRY
		user.setCountry(new Country(1, "MX", "México"));
		user.setRoles(Arrays.asList(
				new Rol(1,"Administrado", "ROLE_ADMIN")
				));

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
			Model model
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
		return "redirect:/show-result";
	}
	
	// user is passed o view by @SessionAttribute no need model..set atributte..
	@GetMapping("/show-result")
	public String showResult(@SessionAttribute(name ="user", required =  false) User user ,Model model,SessionStatus sessionStatus) {
		
		if(user == null) {
			return "redirect:/form";
		}
		sessionStatus.setComplete();
		return "result";
	}
	
	@ModelAttribute("countries")
	public List<String> countries(){
		return Arrays.asList("México","España","Chile", "Perú");
	}
	
	@ModelAttribute("listRoles")
	public List<Rol> listRoles(){
		return this.rolService.list();
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
	
	@ModelAttribute("listRolesString") 
	public List<String> listaRolesString(){
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}
	
	@ModelAttribute("listRolesMap")
	public Map<String, String> listaRolesMap(){
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");
		return roles;
	}
	
	@ModelAttribute("genders")
	public List<String> gender(){
		return Arrays.asList("Hombre", "Mujer");
	}
}
