package org.hillel.it.mycity.bootstrap;

import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		ServiceImpl serviceImpl = new ServiceImpl();
		InMemoryEstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		inMemoryEstablishmentRepository.addCinema(serviceImpl.addEstablishmentCinema("Rodina", "Petrovka str."));
		System.out.println(inMemoryEstablishmentRepository.returnListSize());
		inMemoryEstablishmentRepository.addNightClub(serviceImpl.addEstablishmentNightClub("Palladium", "Kakito str."));
		System.out.println(inMemoryEstablishmentRepository.returnListSize());
	}
}
