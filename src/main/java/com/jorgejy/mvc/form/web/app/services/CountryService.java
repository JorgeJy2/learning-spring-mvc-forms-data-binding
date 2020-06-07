package com.jorgejy.mvc.form.web.app.services;

import java.util.List;

import com.jorgejy.mvc.form.web.app.models.domain.Country;

public interface CountryService {

	public List<Country> list();
	public Country getbyID(Integer id);
}
