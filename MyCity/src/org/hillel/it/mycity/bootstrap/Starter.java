package org.hillel.it.mycity.bootstrap;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.PersonFactory;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryUserRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		EstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		UserRepository inMemoryUserRepository = new InMemoryUserRepository();

		// @timur Вход в систему
		
		String username = "EnteredUsername";
		String password = "EnteredPassword";
		Person loggedPerson = Person.logIn(username, password);
		
		ServiceImpl serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, inMemoryUserRepository, loggedPerson);
		
		Administrator administrator = new Administrator();
		administrator.setCreatedBy(null);
		administrator.setEMail("myMail");
		administrator.setFirstName("Artem");
		administrator.setLogin("ThisAdminLogin");
		administrator.setLastName("Vlasov");
		serviceImpl.addAdministrator(administrator);
		administrator = serviceImpl.getAdministratorById(1);
		
		Cinema cinema = administrator.addEstablishmentCinema();
		
		serviceImpl.addEstablishmentCinema(cinema);
		
		System.out.println(serviceImpl.getCinemaEstablishmentById(1).getCreatedBy().getFirstName());
		
		administrator.deleteEstablishmentById(1, serviceImpl);
		
		System.out.println(serviceImpl.getCinemaEstablishmentById(1).getCreatedBy().getFirstName());
		
	}
}
