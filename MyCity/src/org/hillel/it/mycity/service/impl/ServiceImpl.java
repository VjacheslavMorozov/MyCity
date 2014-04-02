package org.hillel.it.mycity.service.impl;

import java.util.List;

import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.model.entity.RestaurantsAndNightClubs;
import org.hillel.it.mycity.model.entity.Time;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.service.ServiceMyCity;

public class ServiceImpl implements ServiceMyCity {
	private EstablishmentRepository establishmentRepository;
	
	public ServiceImpl(EstablishmentRepository establishmentRepository){
		
		this.establishmentRepository = establishmentRepository;
		
	}
	
	@Override
	public void addEstablishmentRestaurant(
			String nameOfEstablishment, String addressOfEstablishment) {
		
		Restaurant restaurant = new Restaurant();
		restaurant.setNameOfEstablishment(nameOfEstablishment);
		restaurant.setAddressOfEstablishment(addressOfEstablishment);
		establishmentRepository.addEstablishmentRestaurant(restaurant);
		
	}

	@Override
	public void addEstablishmentNightClub(
			String nameOfEstablishment, String addressOfEstablishment) {
		
		NightClub nightClub = new NightClub();
		nightClub.setNameOfEstablishment(nameOfEstablishment);
		nightClub.setAddressOfEstablishment(addressOfEstablishment);
		establishmentRepository.addEstablishmentNightClub(nightClub);
		
	}

	@Override
	public void addEstablishmentCinema(String nameOfEstablishment,
			String addressOfEstablishment) {
		
		Cinema cinema = new Cinema();
		cinema.setNameOfEstablishment(nameOfEstablishment);
		cinema.setAddressOfEstablishment(addressOfEstablishment);
		establishmentRepository.addEstablishmentCinema(cinema);
		
	}
	
	public void deleteEstablishmentByType(String establishmentType) {
		
		establishmentRepository.deleteEstablishmentByType(establishmentType);
		
	}
	
	@Override
	public List<Cinema> getAllCinemaEstablishment(){
		
		if(establishmentRepository.getAllCinemaEstablishment() == null){
			System.out.println("List of Establishment is empty");
			return null;
		}
		return establishmentRepository.getAllCinemaEstablishment();
		
	}
	
	@Override
	public List<NightClub> getAllNightClubEstablishment() {
		
		if(establishmentRepository.getAllNightClubEstablishment() == null){
			System.out.println("List of Establishment is empty");
			return null;
		}
		return establishmentRepository.getAllNightClubEstablishment();
		
	}
	
	@Override
	public List<Restaurant> getAllRestaurantEstablishment() {
		
		if(establishmentRepository.getAllRestaurantEstablishment() == null){
			System.out.println("List of Establishment is empty");
			return null;
		}
		return establishmentRepository.getAllRestaurantEstablishment();
		
	}

	@Override
	public void deleteAllEstablishments() {
		
		establishmentRepository.deleteAllEstablishments();
		
	}

	@Override
	public void deleteEstablishmentById(int id) {
		
		establishmentRepository.deleteEstablishmentById(id);
		
	}

	@Override
	public void deleteComment(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeCommet(String comment) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public <T> T getEstablishmentById(int id, Class<T> type){
		
		return establishmentRepository.getEstablishmentById(id, type);
		
	}
}
