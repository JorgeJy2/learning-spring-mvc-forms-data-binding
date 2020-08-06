package com.jorgejy.mvc.form.web.app.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.jorgejy.mvc.form.web.app.validators.IdentifierRegex;
import com.jorgejy.mvc.form.web.app.validators.Required;

public class User {
	// \\d = [0-9]
	// @Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentifierRegex
	private String id;
	@NotBlank
	@Size(min = 3, max = 8)
	private String username;
	@NotEmpty
	private String password;
	// @NotEmpty
	@NotBlank
	@Email(message = "Correo con formato inválido")
	private String email;
	// @NotEmpty ( message = "El nombre no puede ser vacio")
	private String name;
	// @NotEmpty
	@Required
	private String firstName;

	// INPUT DATE HTML 5 SEND DATE IN FORMAT yyyy/MM/dd
	@NotNull
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	// @Future
	// defaul yyyy/MM/dd
	private Date birthday;

	@NotNull
	@Min(5)
	@Max(5000)
	private Integer count;
	// @NotEmpty
	// @Valid
	@NotNull
	private Country country;

	@NotEmpty
	private List<Rol> roles;

	private Boolean enable;
	
	@NotEmpty
	private String gender;
	
	private String secretValue;
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSecretValue() {
		return secretValue;
	}

	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}

}
