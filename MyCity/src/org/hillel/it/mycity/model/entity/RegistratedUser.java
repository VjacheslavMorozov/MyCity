package org.hillel.it.mycity.model.entity;

import java.util.Date;

public class RegistratedUser extends Person{

	public RegistratedUser(Person administrator) {
		setId();
		setCreateDate(new Date());
		setCreatedBy(administrator);
	}
	
}
