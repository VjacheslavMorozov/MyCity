package org.hillel.it.mycity.service.impl;

import java.util.List;

import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.NightClubs;
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
		establishmentRepository.addEstablishment(restaurant);
		
	}

	@Override
	public void addEstablishmentNightClub(
			String nameOfEstablishment, String addressOfEstablishment) {
		
		NightClubs nightClub = new NightClubs();
		nightClub.setNameOfEstablishment(nameOfEstablishment);
		nightClub.setAddressOfEstablishment(addressOfEstablishment);
		establishmentRepository.addEstablishment(nightClub);
		
	}

	@Override
	public void addEstablishmentCinema(String nameOfEstablishment,
			String addressOfEstablishment) {
		
		Cinema cinema = new Cinema();
		cinema.setNameOfEstablishment(nameOfEstablishment);
		cinema.setAddressOfEstablishment(addressOfEstablishment);
		establishmentRepository.addEstablishment(cinema);
		
	}

	@Override
	public Establishment getEstablishmentById(int id) {

		if(establishmentRepository.getEstablishmentById(id) == null){
			System.out.println("Error. No such id");
			return null;
		}
		return establishmentRepository.getEstablishmentById(id);
	}

	@Override
	public List<Establishment> getAllEstablishment() {
		if(establishmentRepository.getAllEstablishment() == null){
			System.out.println("List of Establishment is empty");
			return null;
		}
		return establishmentRepository.getAllEstablishment();
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
