package org.hillel.it.mycity.model.entity;

import java.util.Date;
 
public class Administrator extends Person{
	
	public Administrator(Person administrator) {
		setId();
		setCreateDate(new Date());
		setCreatedBy(administrator);
	}
	
	public void addEstablishmentCinema() {
		
	}
	
	public void addEstablishmentRestaurant() {
		
	}
	
	public void addEstablishmentNightClub() {
		
	}
	
	public void deleteEstablishmentById(int id) {
		
	}
	
	public void deleteComment() {
		
	}
	
	public void editComment() {
		
	}
	
	public void editEstablishmentInformation() {
		
	}
}
