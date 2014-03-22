package org.hillel.it.mycity.model.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	public void addEstablishment(Establisment establisment){
		
	}
	public void deleteEstablishmentById(){
		
	}
	public void deleteComment(){
		
	}
	public void editComment(){
		
	}
	public void editEstablishmentInformation(){
		
	}
}
