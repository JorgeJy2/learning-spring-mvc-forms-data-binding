package com.jorgejy.mvc.form.web.app.services;

import java.util.List;

import com.jorgejy.mvc.form.web.app.models.domain.Rol;

public interface RolService {

	public List<Rol> list();
	
	public Rol getByID(Integer id);
}
