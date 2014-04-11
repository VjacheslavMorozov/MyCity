package org.hillel.it.mycity.bootstrap;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.PersonFactory;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		EstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();

		// @timur Вход в систему
		
		String username = "EnteredUsername";
		String password = "EnteredPassword";
		Person loggedPerson = Person.logIn(username, password);
		
		ServiceImpl serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, loggedPerson);
		
		Administrator administrator = new Administrator(null);
		
		administrator.setLogin("MyLogin");
		
		serviceImpl.addEstablishmentCinema(administrator);
		serviceImpl.addEstablishmentNightClub(administrator);
		serviceImpl.addEstablishmentRestaurant();
		
		serviceImpl.getCinemaEstablishmentById(2).setAddressOfEstablishment("Rodina str.");
		
	}
}
