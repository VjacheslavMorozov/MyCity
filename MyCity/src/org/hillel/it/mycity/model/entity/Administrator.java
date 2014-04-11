package org.hillel.it.mycity.model.entity;

import java.util.Date;
 
public class Administrator extends Person{
	
	public Cinema addEstablishmentCinema() {
		Cinema cinema = new Cinema();
		cinema.setCreatedBy(this);
		return cinema;
	}
	
	public Restaurant addEstablishmentRestaurant() {
		Restaurant restaurant = new Restaurant();
		restaurant.setCreatedBy(this);
		return restaurant;
	}
	
	public NightClub addEstablishmentNightClub() {
		NightClub nightClub = new NightClub();
		nightClub.setCreatedBy(this);
		return nightClub;
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
