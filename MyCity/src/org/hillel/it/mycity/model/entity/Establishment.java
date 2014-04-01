package org.hillel.it.mycity.model.entity;

import java.util.List;

public abstract class Establishment extends BaseEntity{
	private String nameOfEstablishment;
	private String addressOfEstablishment;
	private String telephoneOfEstablishment; //формат (0482) 34-56-15, можно добавить форматирование по
	private String descriptionOfEstablishment;
	protected Comment commentsOfEstablishment;
	//массив оценок от 1 - 10, из этого массива вычисляется средняя и показывается на странице заведения.
	protected Assessment assessmentsOfEstablishment;
	
	public void setNameOfEstablishment(String nameOfEstablishment){
		
		this.nameOfEstablishment = nameOfEstablishment;
		
	}
	public String getNameOfEstablishment(){
		
		return nameOfEstablishment;
		
	}
	public void setAddressOfEstablishment(String addressOfEstablishment){
		
		this.addressOfEstablishment = addressOfEstablishment;
		
	}
	public String getAddressOfEstablishment(){
		
		return addressOfEstablishment;
		
	}
	public void setTelephoneOfEstablishment(String telephoneOfEstablishment){
		
		if(telephoneOfEstablishment.length() != 10){
			
			System.out.println("Incorrect telephone number. It`s must be ten numbers");
			return;
			
		}
		
		this.telephoneOfEstablishment = telephoneOfEstablishment;
		
	}
	public String getTelephoneOfEstablishment(){
		
		return telephoneOfEstablishment;
		
	}
	public void setDescriptionOfEstablishment(String descriptionOfEstablishment){
		
		this.descriptionOfEstablishment = descriptionOfEstablishment;
		
	}
	public String getDescriptionOfEstablishment(){
		
		return descriptionOfEstablishment;
		
	}
}
