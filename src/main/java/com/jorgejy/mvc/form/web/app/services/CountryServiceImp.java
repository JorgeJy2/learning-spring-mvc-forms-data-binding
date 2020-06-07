package com.jorgejy.mvc.form.web.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jorgejy.mvc.form.web.app.models.domain.Country;

@Service
public class CountryServiceImp implements CountryService {

	private List<Country> list;
	
	public CountryServiceImp() {
		list=  Arrays.asList(
				new Country(1, "MX", "México"),
				new Country(2, "ES", "España"),
				new Country(3, "CL", "Chile"),
				new Country(4, "PR", "Perú"),
				new Country(4, "RD", "Republica"));
	}

	@Override
	public List<Country> list() {
		return list;
	}

	@Override
	public Country getbyID(Integer id) {
		Country result = null;
		for(Country country: this.list) {
			if(id == country.getId()) {
				result = country;
				break;
			}
		}
		return result;
	}

}
