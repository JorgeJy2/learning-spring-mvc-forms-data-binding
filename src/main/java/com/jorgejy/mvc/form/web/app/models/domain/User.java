package com.jorgejy.mvc.form.web.app.models.domain;

import javax.validation.constraints.NotEmpty;

public class User {
	
	private String id;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String email;
	@NotEmpty
	private String name;
	@NotEmpty
	private String firstName;
	
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
	
}
