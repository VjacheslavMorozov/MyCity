package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.List;

public class NightClubs extends RestaurantsAndNightClubs{
	public NightClubs(){
		assessment = new ArrayList<>();
		averageAssessment = 0;
		sumOfAssessment = 0;
		id++;
	}
	public String getNameOfEstablishment() {
		return nameOfEstablishment;
	}
	public void setNameOfEstablishment(String nameOfEstablishment) {
		this.nameOfEstablishment = nameOfEstablishment;
	}
	public String getAddressOfEstablishment() {
		return addressOfEstablishment;
	}
	public void setAddressOfEstablishment(String addressOfEstablishment) {
		this.addressOfEstablishment = addressOfEstablishment;
	}
	public String getTelephoneOfEstablishment() {
		return telephoneOfEstablishment;
	}
	public void setTelephoneOfEstablishment(String telephoneOfEstablishment) {
		this.telephoneOfEstablishment = telephoneOfEstablishment;
	}
	public String getDescriptionOfEstablishment() {
		return descriptionOfEstablishment;
	}
	public void setDescriptionOfEstablishment(String descriptionOfEstablishment) {
		this.descriptionOfEstablishment = descriptionOfEstablishment;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment.setComment(comment);
	}
	public void setTimeOpen(Time timeOpen){
		this.timeOpen = timeOpen;
	}
	public Time getTimeOpen(){
		return timeOpen;
	}
	public void setTimeClose(Time timeClose){
		this.timeClose = timeClose;
	}
	public Time getTimeClose(){
		return timeClose;
	}
	public void setAverageCheck(int averageCheck){
		this.averageCheck = averageCheck;
	}
	public int getAverageCheck(){
		return averageCheck;
	}
	public void setAdditionalService(String additionalService){
		
	}
	public String getAdditionalService(){
		return null;
	}
	/*Я думаю, что лучше создать отдельный класс под Оценки, так как, каждый пользователь может их менять
	*То есть каждый пользователь имеет свой ID, который показывает его оценку, эту оценку он может поменять
	*Соотвественно эту оценку нужно хранить, например в interface Map - один Id - Одна Assessment*/
	public double getAssessment() {
		return (double) sumOfAssessment/assessment.size();
	}
	public void setAssessment(int assessment) {
		this.assessment.add(assessment);
		sumOfAssessment += assessment;
	}
	public int getId(){
		return id;
	}
}
