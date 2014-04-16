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
	
	//не уверен с передаваемыми аргумента, надо у Сергея узнать.
	public void deleteEstablishmentById(int id, ServiceImpl serviceImpl) {
		serviceImpl.deleteEstablishmentById(id);
	}
	
	public void deleteCommentById(int id, ServiceImpl serviceImpl) {
		//TODO
	}
	
	public void editComment(String editComment, int id, ServiceImpl serviceImpl) {
		//TODO
	}
	
	public void editEstablishmentInformation() {
		//TODO
	}

	@Override
	public String toString() {
		return "Administrator [firstName=" + getFirstName() + ", lastName="
				+ getLastName() + ", username=" + getUsername() + ", password="
				+ getPassword() + "]";
	}
	
	
}
