package org.hillel.it.mycity.model.entity;

public class Time {
	private int hour;
	private int minute;
	
	public void setTime(int hour, int minute){
		
		if(hour < 0 || hour > 23 || minute < 0 || minute > 59){
			
			System.out.println("Incorrect time. Correct time: hour = 0 - 23, minute =  0 - 59.");
			return;
		}
		this.hour = hour;
		this.minute = minute;
	}
	public int getTimeInMinute(){
		
		return hour * 60 + minute;
		
	}

}
