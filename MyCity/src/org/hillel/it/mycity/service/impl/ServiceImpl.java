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
	
	@Override
	public Cinema getEstablishmentCinemaById(int id){
		
		if(establishmentRepository.getEstablishmentCinemaById(id) == null){
			System.out.println("Error. No such id");
			return null;
		}
		return establishmentRepository.getEstablishmentCinemaById(id);
		
	}
	
	@Override
	public NightClub getEstablishmentNightClubById(int id) {
	
		if(establishmentRepository.getEstablishmentNightClubById(id) == null){
			System.out.println("Error. No such id");
			return null;
		}
		return establishmentRepository.getEstablishmentNightClubById(id);
		
	}
	
	@Override
	public Restaurant getEstablishmentRestaurantById(int id) {
		
		if(establishmentRepository.getEstablishmentRestaurantById(id) == null){
			System.out.println("Error. No such id");
			return null;
		}
		return establishmentRepository.getEstablishmentRestaurantById(id);
		
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
}
