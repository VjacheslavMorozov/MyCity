package org.hillel.it.mycity.bootstrap;

import java.io.ObjectInputStream.GetField;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		InMemoryEstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		ServiceImpl serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository);
		
		Administrator administrator = new Administrator(null);
		
		serviceImpl.addEstablishmentCinema("Planeta-Kino", "Rivera", administrator);
		serviceImpl.addEstablishmentNightClub("Palladium", "Italian blv.", administrator);
		serviceImpl.addEstablishmentRestaurant("Steak", "Deribasovskaya str.", administrator);
		
		Cinema cinema = serviceImpl.getCinemaEstablishmentById(2);
		
	}
}
