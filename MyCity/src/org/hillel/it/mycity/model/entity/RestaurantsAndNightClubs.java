package org.hillel.it.mycity.model.entity;

public abstract class RestaurantsAndNightClubs extends Establishment{
	//protected AdditionalService additionalService; //я думаю, что можно создать класс с дополнительными услугами.
	private Time timeOpen = new Time();
	private Time timeClose = new Time();
	private int averageCheck;
	
		
	public RestaurantsAndNightClubs(Person person) {
		super(person);
	}
	public void setAverageCheck(int averageCheck){
		
		this.averageCheck = averageCheck;
		
	}
	public int getAverageCheck(){
		
		return averageCheck;
		
	}
	public void setTimeOpen(int hour, int minute){
		
		timeOpen.setTime(hour, minute);
		
	}
	public int getTimeOpenInMinute(){
		
		return timeOpen.getTimeInMinute();
		
	}
	public void setTimeClose(int hour, int minute){
		
		timeClose.setTime(hour, minute);
		
	}
	public int getTimeCloseInMinute(){
		
		return timeClose.getTimeInMinute();
		
	}
}
