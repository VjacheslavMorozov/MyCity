package org.hillel.it.mycity.model.entity;

import java.util.Date;

public class Moderator extends Person{
	
	public Moderator(Person administrator) {
		setId();
		setCreateDate(new Date());
		setCreatedBy(administrator);
	}
	
}
