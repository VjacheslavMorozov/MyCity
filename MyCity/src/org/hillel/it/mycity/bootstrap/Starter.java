package org.hillel.it.mycity.bootstrap;

import org.hillel.it.mycity.info.Configuration;
import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.AssessmentRepository;
import org.hillel.it.mycity.persistence.repository.CommentRepository;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.FileUserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryAssessmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryCommentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.service.ServiceMyCity;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		EstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		UserRepository inMemoryUserRepository = new FileUserRepository();
		CommentRepository inMemoryCommentRepository = new InMemoryCommentRepository();
		AssessmentRepository inMemoryAssessmentRepository = new InMemoryAssessmentRepository();
		
		ServiceMyCity serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, inMemoryUserRepository, inMemoryCommentRepository, inMemoryAssessmentRepository);
		
		Configuration configuration = Configuration.getInstance();
		System.out.println(configuration.getFilePath());
		
		serviceImpl.deleteUsers();
		
		Administrator administrator = new Administrator("mymail@mail.com", "password");
		serviceImpl.addAdministrator(administrator);
		Moderator moderator = new Moderator("mymail@mail.com", "password");
		serviceImpl.addModerator(moderator);
		User user = new User("mymail@mail.com", "password");
		serviceImpl.addUser(user);
		
		serviceImpl.deleteUsers();
		
		serviceImpl.deserializeUserData();
		System.out.println(serviceImpl.getAdministrator(1).getEmail());
		
		administrator = new Administrator("mymail1@mail.com", "password");
		serviceImpl.addAdministrator(administrator);
		System.out.println(serviceImpl.getAdministrator(4).getEmail());
		
		
	}
}
