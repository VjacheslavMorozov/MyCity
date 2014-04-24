package org.hillel.it.mycity.bootstrap;

import java.io.IOException;
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
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.AssessmentRepository;
import org.hillel.it.mycity.persistence.repository.CommentRepository;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryAssessmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryCommentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryUserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.SerializationUserRepository;
import org.hillel.it.mycity.service.ServiceMyCity;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		EstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		UserRepository inMemoryUserRepository = new InMemoryUserRepository();
		CommentRepository inMemoryCommentRepository = new InMemoryCommentRepository();
		AssessmentRepository inMemoryAssessmentRepository = new InMemoryAssessmentRepository();
		
		ServiceMyCity serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, inMemoryUserRepository, inMemoryCommentRepository, inMemoryAssessmentRepository);
		
		/*Administrator administrator = new Administrator("mymail@mail.com", "password");
		serviceImpl.addAdministrator(administrator);
		inMemoryUserRepository.sereializeUserData();*/
		
		inMemoryUserRepository.deserializeUserData();
		Administrator administrator = serviceImpl.getAdministrator(1);
		serviceImpl.setLoggedUser(administrator);
		
		serviceImpl.addCinema(administrator.createEstablishmentCinema());
		
		System.out.println(inMemoryEstablishmentRepository.getMaxId());
		
		int id = inMemoryEstablishmentRepository.getMaxId();
		
		id++;
		
		System.out.println(id);
		
		System.out.println(inMemoryEstablishmentRepository.getMaxId());
		
		System.out.println(serviceImpl.getAdministrator(1).getEmail());
		
	}
}
