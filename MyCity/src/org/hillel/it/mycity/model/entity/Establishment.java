package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Establishment extends BaseEntity{
	private String nameOfEstablishment;
	private String addressOfEstablishment;
	private String telephoneOfEstablishment; //формат (0482) 34-56-15, можно добавить форматирование по
	private String descriptionOfEstablishment;
	private List<Comment> commentsOfEstablishment;
	private List<Assessment> assessmentsOfEstablishment;
	
	public Establishment() {
		commentsOfEstablishment = new ArrayList<>();
		assessmentsOfEstablishment = new ArrayList<>();
	}
	
	public void setNameOfEstablishment(String nameOfEstablishment){
		this.nameOfEstablishment = nameOfEstablishment;
	}

	public String getNameOfEstablishment() {
		return nameOfEstablishment;
	}
	
	public void setAddressOfEstablishment(String addressOfEstablishment) {
		this.addressOfEstablishment = addressOfEstablishment;
	}
	
	public String getAddressOfEstablishment() {
		return addressOfEstablishment;
	}
	
	public void setTelephoneOfEstablishment(String telephoneOfEstablishment) {
		if(!checkTelephoneOfEstablishment(telephoneOfEstablishment)) {
			System.out.println("Incorrect format");
			return;
		}
		this.telephoneOfEstablishment = telephoneOfEstablishment;
	}
	
	public String getTelephoneOfEstablishment() {
		return telephoneOfEstablishment;
	}
	
	public void setDescriptionOfEstablishment(String descriptionOfEstablishment) {
		this.descriptionOfEstablishment = descriptionOfEstablishment;
	}
	
	public String getDescriptionOfEstablishment() {
		return descriptionOfEstablishment;
	}
	
	/**
	 * Method that set comment for Establishment. checkEstablishment - check if this comment is belongs 
	 * to this Establishment (if it was changed). checkId - check if this comment is created in Repository
	 * or have correct id;
	 * @param comment
	 */
	public void setComment(Comment comment) {
		checkAddComment(comment);
		comment.setEstablishment(this);
		commentsOfEstablishment.add(comment);
	}
	
	public void setAssessment(Assessment assessment) {
			checkAddAssessment(assessment);
		assessment.setEstablishment(this);
		assessmentsOfEstablishment.add(assessment);
	}
	
	/**
	 * Check insert telephone number on regex. Standart format 0939580099. Check Telephones for 
	 * Odessa Region.
	 * @param telephoneOfEstablishment
	 * @return true if telephone number is in standart format
	 */
	public boolean checkTelephoneOfEstablishment(String telephoneOfEstablishment) {
		Pattern telephonePattern = Pattern.compile("(^0([6][3678]|[9][1-9]|39|48|50))\\d{7}");
		Matcher telephoneMatcher = telephonePattern.matcher(telephoneOfEstablishment);
		return telephoneMatcher.find();
	}
	
	public void checkAddComment(Comment comment) {
		try {
			comment.checkEstablishment(this);
			comment.checkId(comment.getId());
		} catch (RuntimeException e) {
			System.out.println("Problem with comment: " + e);
			throw new RuntimeException();
		}
	}
	
	public void checkAddAssessment(Assessment assessment) {
		try {
			assessment.checkEstablishment(this);
			assessment.checkId(assessment.getId());
		} catch (RuntimeException e) {
			System.out.println("Problem with Assessment: " + e);
			throw new RuntimeException();
		}
	}
}
