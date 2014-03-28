package org.hillel.it.mycity.service;

import java.util.Date;
import java.util.List;

import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Time;

public interface ServiceMyCity {
	//Users
	public void setUserName(String userName);
	public String getUserName();
	//Administrator and Moderator
	public void deleteComment(int id);
	public void editComment(Comment comment);
	//Administrator
	public void addEstablishmentCinema();
	public void addEstablishmentRestaurant();
	public void addEstablishmentNightClub();
	public void deleteEstablishment(int id);
	public void editEstablismentInformation(int id);
	//RegistratedUser
	public void writeCommet(String comment);
	public void setAssessmentToEstablishment(int assessment);
	public void setAssessmentToComment(boolean sign);
	//Moderator
	public boolean markEstablismentToDelete();
	public boolean markEstablismentToEdit();
	//Comment
	public void setComment(String comment);
	public List<String> getCommentsForEstablisment();
	public void setCommentPositiveAssessment(String comment);
	public void setCommentNegativeAssessment(String comment);
	public int getCommentAssessment(String comment);
	//For Establisment
	public void setNameOfEstablishment(String nameOfEstablishment);
	public String getNameOfEstablishment();
	public void setAddressOfEstablishmetn(String addressOfEstablishment);
	public String getAddressOfEstablishment();
	public String getTelephoneOfEstablishment();
	public void setTelephoneOfEstablishment(String telephoneOfEstablishment);
	public String getDescriptionOfEstablishment();
	public void setDescriptionOfEstablishment(String descriptionOfEstablishment);
	public Comment getComment();
	public double getAssessment();
	public void setAssessment(int assessment);
	public void setDateOfCreation(Date date);
	public Date getDateOfCreation();
	public void setDateOfModification(Date date);
	public void getDateOfModification();
	public int getId();
	//Cinema
	public int getNumberOfHalls();
	public void setNumberOfHalls(int numberOfHalls);
	public int getNumberOfSeatsInHall();
	public void setNumberOfSeatsInHall(int numberOfSeatsInHall);
	public String getCinemaTechnology();
	public void setCinemaTechnology(String cinemaTechnology);
	//NightClubs and Restaurant
	public void setTimeOpen(Time timeOpen);
	public Time getTimeOpen();
	public void setTimeClose(Time timeClose);
	public Time getTimeClose();
	public void setAverageCheck(int averageCheck);
	public int getAverageCheck();
	public void setAdditionalService(String additionalService);
	public String getAdditionalService();
}
