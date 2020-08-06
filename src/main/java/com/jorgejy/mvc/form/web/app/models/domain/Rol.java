package com.jorgejy.mvc.form.web.app.models.domain;

public class Rol {

	private Integer id;
	private String name;
	private String code;

	public Rol() {
	}

	public Rol(Integer id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Rol)) {
			return false;
		}

		Rol rol = (Rol) obj;

		return this.id != null && this.id.equals(rol.getId());
	}

}
