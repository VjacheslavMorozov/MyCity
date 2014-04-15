package org.hillel.it.mycity.bootstrap;

import java.util.ArrayList;
import java.util.List;

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

		// example input data
		List<Person> admins = new ArrayList<>();
		admins.add(new Administrator("Vlasov","Artem","username","password"));
		admins.add(new Administrator("Aminev","Timur","tim8917","mypass"));
		for(Person admin : admins){
			System.out.println(admin);			
		}
		


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
