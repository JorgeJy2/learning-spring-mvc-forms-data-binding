package com.jorgejy.mvc.form.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jorgejy.mvc.form.web.app.services.RolService;

 
@Component
public class RolPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private RolService roleService;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {		
		try {
			Integer id = Integer.parseInt(text);
			this.setValue(roleService.getByID(id));
		} catch (NumberFormatException e) {
			this.setValue(null);
		}
	}
}