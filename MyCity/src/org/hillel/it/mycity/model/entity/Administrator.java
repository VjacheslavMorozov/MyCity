package org.hillel.it.mycity.model.entity;

import java.util.HashMap;
import java.util.Map;
 
public class Administrator{
	private Map<String, String> usersInformation;
	Administrator(){
		usersInformation = new HashMap<>();
	}
	public void setUserName(String userName){
		if(usersInformation.containsValue(userName)){
			System.out.println("Error. Administrator with this username is available");
			return;
		}
		usersInformation.put("username", userName);
	}
	public String getUserName(){
		return usersInformation.get("username");
	}
	public void addEstablishmentCinema(){
		Establishment establishment = new Cinema();
	}
	public void addEstablishmentRestaurant(){
		Establishment establishment = new Restaurant();
	}
	public void addEstablishmentNightClub(){
		Establishment establishment = new NightClub();
	}
	public void deleteEstablishmentById(int id){
		
	}
	public void deleteComment(){
		
	}
	public void editComment(){
		
	}
	public void editEstablishmentInformation(){
		
	}
}
