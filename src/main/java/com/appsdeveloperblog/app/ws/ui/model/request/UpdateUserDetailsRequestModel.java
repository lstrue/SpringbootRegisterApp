package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

	@NotNull(message="first name cannot be null")
	@Size(min=2, max=16, message="first name must be greater than 2 chars")
	private String firstName;
	
	@NotNull
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
}
