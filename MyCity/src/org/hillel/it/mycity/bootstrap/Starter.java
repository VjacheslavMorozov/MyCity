package org.hillel.it.mycity.bootstrap;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.PersonFactory;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.persistence.repository.CommentRepository;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryCommentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryUserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.SerializeEstablishmentRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		EstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		UserRepository inMemoryUserRepository = new InMemoryUserRepository();
		CommentRepository inMemoryCommentRepository = new InMemoryCommentRepository();

		// example input data
		/*List<Person> admins = new ArrayList<>();
		admins.add(new Administrator("Vlasov","Artem","username","password")); //такие объекты ничего не могу создать, так как у них нет ID
		admins.add(new Administrator("Aminev","Timur","tim8917","mypass"));
		for(Person admin : admins){
			System.out.println(admin);			
		}*/

		// @timur Вход в систему
		ServiceImpl serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, inMemoryUserRepository, inMemoryCommentRepository);
		
		Administrator administrator = new Administrator("tim8917@gmail.com","mypass");
		
		// input data to UserRepository
		serviceImpl.addAdministrator(administrator);
		
		administrator = serviceImpl.getAdministratorById(1);
		
		Restaurant restaurant = administrator.addEstablishmentRestaurant();
		restaurant.setAddressOfEstablishment("Street");
		restaurant.setNameOfEstablishment("Bellini");
		
		serviceImpl.setLoggedUser(administrator);
		
		serviceImpl.addEstablishmentRestaurant(restaurant);
		
		restaurant = serviceImpl.getRestaurantEstablishmentById(1);
		
		System.out.println(restaurant.getAddressOfEstablishment() + " " + restaurant.getNameOfEstablishment() + " " + restaurant.getId());
		
		EstablishmentRepository serializeEstablishmentRepository = new SerializeEstablishmentRepository();
		
		Cinema cinema = new Cinema();
		cinema.setAddressOfEstablishment("Street");
		cinema.setCinemaTechnology("3D");
		cinema.setNameOfEstablishment("Rodina");
		
		serializeEstablishmentRepository.addEstablishmentCinema(cinema);
		
	}
}
