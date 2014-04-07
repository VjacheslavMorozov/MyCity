package org.hillel.it.mycity.bootstrap;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		EstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		ServiceImpl serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository);
		
		Administrator administrator = new Administrator(null);
		
		serviceImpl.addEstablishmentCinema(administrator);
		serviceImpl.addEstablishmentNightClub(administrator);
		serviceImpl.addEstablishmentRestaurant(administrator);
		
		Cinema cinema = serviceImpl.getCinemaEstablishmentById(2);
		
	}
}
