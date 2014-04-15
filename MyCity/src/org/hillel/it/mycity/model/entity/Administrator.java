package org.hillel.it.mycity.model.entity;

import org.hillel.it.mycity.service.impl.ServiceImpl;
 
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
}
