package org.hillel.it.mycity.service.impl;

import java.util.Date;
import java.util.List;

import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.NightClubs;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.model.entity.Time;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.service.ServiceMyCity;

public class ServiceImpl implements ServiceMyCity {
	private EstablishmentRepository establishmentRepository;
	
	public ServiceImpl(){
		establishmentRepository = new EstablishmentRepository() {
			
			@Override
			public int deleteEstablishmentById(int id) {
				return id;
			}
			
			@Override
			public Establishment addEstablishmentRestaurant(String nameOfEstablishment, String addressOfEstablishment) {
				
				Restaurant restaurant = new Restaurant();
				
				restaurant.setNameOfEstablishment(nameOfEstablishment);
				restaurant.setAddressOfEstablishment(addressOfEstablishment);
				
				return restaurant;
				
			}
			
			@Override
			public Establishment addEstablishmentNightClub(String nameOfEstablishment, String addressOfEstablishment) {
				
				NightClubs nightClub = new NightClubs();
				
				nightClub.setNameOfEstablishment(nameOfEstablishment);
				nightClub.setAddressOfEstablishment(addressOfEstablishment);
				
				return nightClub;
				
			}
			
			@Override
			public Establishment addEstablishmentCinema(String nameOfEstablishment, String addressOfEstablishment) {
				
				Cinema cinema = new Cinema();
				
				cinema.setNameOfEstablishment(nameOfEstablishment);
				cinema.setAddressOfEstablishment(addressOfEstablishment);
				
				return cinema;
				
			}
		};
	}
	public Establishment addEstablishmentCinema(String nameOfEstablishment, String addressOfEstablishment){
		return establishmentRepository.addEstablishmentCinema(nameOfEstablishment, addressOfEstablishment);
	}
	public Establishment addEstablishmentNightClub(String nameOfEstablishment, String addressOfEstablishment){
		return establishmentRepository.addEstablishmentNightClub(nameOfEstablishment, addressOfEstablishment);
	}
	public Establishment addEstablishmentRestaurant(String nameOfEstablishment, String addressOfEstablishment){
		return establishmentRepository.addEstablishmentRestaurant(nameOfEstablishment, addressOfEstablishment);
	}
	public int deleteEstablishmentById(int id){
		return establishmentRepository.deleteEstablishmentById(id);
	}
	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteComment(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addEstablishmentCinema() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addEstablishmentRestaurant() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addEstablishmentNightClub() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteEstablishment(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editEstablismentInformation(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void writeCommet(String comment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setAssessmentToEstablishment(int assessment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setAssessmentToComment(boolean sign) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean markEstablismentToDelete() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean markEstablismentToEdit() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setComment(String comment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<String> getCommentsForEstablisment() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCommentPositiveAssessment(String comment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setCommentNegativeAssessment(String comment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getCommentAssessment(String comment) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setNameOfEstablishment(String nameOfEstablishment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getNameOfEstablishment() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAddressOfEstablishmetn(String addressOfEstablishment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getAddressOfEstablishment() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getTelephoneOfEstablishment() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setTelephoneOfEstablishment(String telephoneOfEstablishment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getDescriptionOfEstablishment() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setDescriptionOfEstablishment(String descriptionOfEstablishment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Comment getComment() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getAssessment() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setAssessment(int assessment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setDateOfCreation(Date date) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Date getDateOfCreation() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setDateOfModification(Date date) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getDateOfModification() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getNumberOfHalls() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setNumberOfHalls(int numberOfHalls) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getNumberOfSeatsInHall() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setNumberOfSeatsInHall(int numberOfSeatsInHall) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getCinemaTechnology() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCinemaTechnology(String cinemaTechnology) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setTimeOpen(Time timeOpen) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Time getTimeOpen() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setTimeClose(Time timeClose) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Time getTimeClose() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAverageCheck(int averageCheck) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getAverageCheck() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setAdditionalService(String additionalService) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getAdditionalService() {
		// TODO Auto-generated method stub
		return null;
	}
}
