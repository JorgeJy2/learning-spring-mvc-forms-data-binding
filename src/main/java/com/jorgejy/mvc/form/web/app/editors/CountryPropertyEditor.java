package com.jorgejy.mvc.form.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jorgejy.mvc.form.web.app.services.CountryServiceImp;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private CountryServiceImp countryService;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(idString);
			this.setValue(countryService.getbyID(id));
		} catch (NumberFormatException e) {
			setValue(null);
		}

	}
}
