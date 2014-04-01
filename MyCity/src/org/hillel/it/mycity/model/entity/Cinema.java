package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Cinema extends Establishment{
	private int numberOfHalls;
	private int numberOfSeatsInHall;
	private String cinemaTechnology;
	public Cinema(){
		
		setId();
		commentsOfEstablishment = new Comment();
		assessmentsOfEstablishment = new Assessment();
		
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
}
