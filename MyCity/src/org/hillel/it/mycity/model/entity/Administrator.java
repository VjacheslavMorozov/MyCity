package org.hillel.it.mycity.model.entity;

import java.util.Date;
 
public class Administrator extends Person{
	
	public Administrator(Person administrator) {
		setId();
		setCreateDate(new Date());
		setCreatedBy(administrator);
	}
	
	public void addEstablishmentCinema() {
		//TODO
	}
	
	public void addEstablishmentRestaurant() {
		//TODO
	}
	
	public void addEstablishmentNightClub() {
		//TODO
	}
	
	public void deleteEstablishmentById(int id) {
		//TODO
	}
	
	public void deleteComment() {
		//TODO
	}
	
	public void editComment() {
		//TODO
	}
	
	public void editEstablishmentInformation() {
		//TODO
	}
}
