package org.hillel.it.mycity.service.impl;

import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.NightClubs;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;

public class ServiceImpl {
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
}
