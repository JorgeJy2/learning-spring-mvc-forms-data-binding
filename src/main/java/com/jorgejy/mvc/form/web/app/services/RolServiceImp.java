package com.jorgejy.mvc.form.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.jorgejy.mvc.form.web.app.models.domain.Rol;

@Service
public class RolServiceImp implements RolService {

	private List<Rol> roles;
	
	public RolServiceImp() {
		this.roles = new ArrayList<Rol>();
		this.roles.add(new Rol(1,"Administrado", "ROLE_ADMIN"));
		this.roles.add(new Rol(2,"Usuario", "ROLE_USER"));
		this.roles.add(new Rol(3,"Moderador", "ROLE_MODERATOE"));
	}
	
	@Override
	public List<Rol> list() {
		return roles;
	}

	@Override
	public Rol getByID(Integer id) {
		Rol result = null;
		for(Rol rol: roles) {
			if(id == rol.getId()) {
				result = rol;
				break;
			}
		}
		return result;		
	}

}
