package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Cinema extends Establisment{
	private int numberOfHalls;
	private int numberOfSeatsInHall;
	private String cinemaTechnology;
	Cinema(){
		assessment = new ArrayList();
		averageAssessment = 0;
		sumOfAssessment = 0;
		id++;
	}
	public void setNameOfEstablishment(String nameOfEstablishment){
		this.nameOfEstablishment = nameOfEstablishment;
	}
	public String getNameOfEstabishment(){
		return nameOfEstablishment;
	}
	public void setAddressOfEstabishment(String addressOfEstablishment){
		this.addressOfEstablishment = addressOfEstablishment;
	}
	public String getAddressOfEstabishment(){
		return addressOfEstablishment;
	}
	public int getNumberOfHalls() {
		return numberOfHalls;
	}
	public void setNumberOfHalls(int numberOfHalls) {
		this.numberOfHalls = numberOfHalls;
	}
	public int getNumberOfSeatsInHall() {
		return numberOfSeatsInHall;
	}
	public void setNumberOfSeatsInHall(int numberOfSeatsInHall) {
		this.numberOfSeatsInHall = numberOfSeatsInHall;
	}
	public String getCinemaTechnology() {
		return cinemaTechnology;
	}
	public void setCinemaTechnology(String cinemaTechnology) {
		this.cinemaTechnology = cinemaTechnology;
	}
	public String getTelephoneOfEstabishment() {
		return telephoneOfEstablishment;
	}
	public void setTelephoneOfEstabishment(String telephoneOfEstablishment) {
		this.telephoneOfEstablishment = telephoneOfEstablishment;
	}
	public String getDescriptionOfEstabishment() {
		return descriptionOfEstablishment;
	}
	public void setDescriptionOfEstabishment(String descriptionOfEstablishment) {
		this.descriptionOfEstablishment = descriptionOfEstablishment;
	}
	public void setComment(String comment){
		this.comment.setComment(comment);
	}
	public Comment getComment(){
		return comment;
	}
	public double getAssessment() {
		return (double) sumOfAssessment/assessment.size();
	}
	public void setAssessment(int assessment) {
		this.assessment.add(assessment);
		sumOfAssessment += assessment;
	}
	public void setDateOfCreation(Date date){
		this.created = date;
	}
	public Date getDateOfCreation(){
		return created;
	}
	public void setDateOfModification(Date date){
		this.modified = date;
	}
	public Date getDateOfModification(){
		return modified;
	}
}
