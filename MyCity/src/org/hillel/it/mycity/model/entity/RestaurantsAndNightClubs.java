package org.hillel.it.mycity.model.entity;

public abstract class RestaurantsAndNightClubs extends Establishment{
	//protected AdditionalService additionalService; //я думаю, что можно создать класс с дополнительными услугами.
	private Time timeOpen = new Time();
	private Time timeClose = new Time();
	private int averageCheck;
	
	public void setAverageCheck(int averageCheck) {
		this.averageCheck = averageCheck;
	}
	
	public int getAverageCheck() {
		return averageCheck;
	}
	
	public void setTimeOpen(int hour, int minute) {	
		timeOpen.setTime(hour, minute);
	}
	
	public int getTimeOpenInMinute() {
		return timeOpen.getTimeInMinute();
	}
	
	public void setTimeClose(int hour, int minute) {
		timeClose.setTime(hour, minute);
	}
	
	public int getTimeCloseInMinute() {	
		return timeClose.getTimeInMinute();
	}
	
	protected String getRestAndNCSQLData() {
		String rsnc = "";
		if(timeOpen.getTimeInMinute() > 0) {
			int minute = timeOpen.getTimeInMinute()%60;
			int hour = (timeOpen.getTimeInMinute()-minute)/60;
			rsnc = rsnc + ", timeOpen = " + hour + ":" + minute + ":00";
		}
		if(timeClose.getTimeInMinute() > 0) {
			int minute = timeClose.getTimeInMinute()%60;
			int hour = (timeClose.getTimeInMinute()-minute)/60;
			rsnc = rsnc + ", timeClose = " + hour + ":" + minute + ":00";
		}
		if(averageCheck > 0) {
			rsnc = rsnc + ", averageCheck = " + averageCheck;			
		}
		return rsnc;
	}
}
