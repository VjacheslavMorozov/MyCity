package org.hillel.it.mycity.model.entity;

import java.util.HashMap;
import java.util.Map;

public class RegistratedUser {
	private Map<String, String> usersInformation;
	RegistratedUser(){
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
	public void writeCommet(String comment){
		
	}
	public void setAssessmentToEstablisment(int Assessment){
		
	}
	public void setAssessmentToComment(boolean sign){
		
	}
}
