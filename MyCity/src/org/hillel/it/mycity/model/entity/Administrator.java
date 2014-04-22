package org.hillel.it.mycity.model.entity;

import org.hillel.it.mycity.service.impl.ServiceImpl;
 
public class Administrator extends Person {
	
	public Administrator(String email, String password) {
		super(email, password);
	}
	
	//лучше делать через Setter и вынести этот конструктор в базовый класс Person. И оставить только
	//главные поля - password и email
	/*public Administrator(String lastName, String firstName, String username, String password){
		this.lastName = lastName;
		this.firstName = firstName;
		this.username = username;
		this.setPassword(password);		
	}*/
	
	public Cinema createEstablishmentCinema() {
		Cinema cinema = new Cinema();
		cinema.setCreatedBy(this);
		return cinema;
	}
	
	public Restaurant createEstablishmentRestaurant() {
		Restaurant restaurant = new Restaurant();
		restaurant.setCreatedBy(this);
		return restaurant;
	}
	
	public NightClub createEstablishmentNightClub() {
		NightClub nightClub = new NightClub();
		nightClub.setCreatedBy(this);
		return nightClub;
	}
	
	public void deleteEstablishment(int id) {
		
	}
	
	public void deleteComment(int id) {
	
	}
	
	public void editComment(String editComment, int id) {
		
	}

	@Override
	public String toString() {
		return "Administrator [firstName=" + getFirstName() + ", lastName="
				+ getLastName() + ", username=" + getUsername() + ", password="
				+ getPassword() + "]";
	}
	
	
}
