package org.hillel.it.mycity.model.entity;

public class Cinema extends Establishment{
	private int numberOfHalls;
	private int numberOfSeatsInHall;
	private String cinemaTechnology;
	
	public Cinema() {
		super();
	}
	
	public void setNumberOfHalls(int numberOfHalls) {
		this.numberOfHalls = numberOfHalls;
	}
	
	public int getNumberOfHalls() {
		return numberOfHalls;
	}
	
	public void setNumberOfSeatsInHall(int numberOfSeatsInHall) {
		this.numberOfSeatsInHall = numberOfSeatsInHall;
	}
	
	public int getNumberOfSeatsInHall() {
		return numberOfSeatsInHall;
	}
	
	public void setCinemaTechnology(String cinemaTechnology) {
		this.cinemaTechnology = cinemaTechnology;
	}
	
	public String getCinemaTechnology() {	
		return cinemaTechnology;
	}
	
	
	public String getCinemaSQLData() {
		String cinemaString = "cinemaEstablishment = (SELECT MAX(idEstablishment) FROM Establishment)";
		int stringLength = cinemaString.length();
		if(numberOfHalls > 0) {
			cinemaString = cinemaString + ", numberOfHalls = " + numberOfHalls;
		}
		if(numberOfSeatsInHall > 0) {
			cinemaString = cinemaString + ", numberOfSeatsInHall = " + numberOfSeatsInHall;
		}
		if(cinemaTechnology != null) {
			cinemaString = cinemaString + ", cinemaTechnology = " + "'" + cinemaTechnology + "'";
		}
		if(stringLength == cinemaString.length()) {
			return "";
		} else {
			return cinemaString;
		}
		
	}
}
