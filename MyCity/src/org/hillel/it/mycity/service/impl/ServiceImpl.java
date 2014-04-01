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
		
		RestaurantsAndNightClubs restaurant = new Restaurant();
		restaurant.setNameOfEstablishment(nameOfEstablishment);
		restaurant.setAddressOfEstablishment(addressOfEstablishment);
		establishmentRepository.addEstablishment(restaurant);
		
	}

	@Override
	public void addEstablishmentNightClub(
			String setNameOfEstablishment, String addressOfEstablishment) {
		Establishment nightClub = new NightClubs()
	}

	@Override
	public void addEstablishmentCinema(String setNameOfEstablishment,
			String addressOfEstablishment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Establishment getEstablishmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Establishment> getAllEstablishment(
			List<Establishment> establishments) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAllEstablishments(List<Establishment> establishments) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEstablishmentById(int id) {
		// TODO Auto-generated method stub
		return false;
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
