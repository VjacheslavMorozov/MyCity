package org.hillel.it.mycity.bootstrap;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.hillel.it.mycity.info.Configuration;
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
import org.hillel.it.mycity.persistence.repository.inmemory.FileUserRepository;
import org.hillel.it.mycity.service.ServiceMyCity;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		EstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		FileUserRepository fileUserRepository = new FileUserRepository();
		CommentRepository inMemoryCommentRepository = new InMemoryCommentRepository();
		AssessmentRepository inMemoryAssessmentRepository = new InMemoryAssessmentRepository();
		
		ServiceMyCity serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, fileUserRepository, inMemoryCommentRepository, inMemoryAssessmentRepository);
		
		Configuration configuration = Configuration.getInstance();
		configuration.getFilePath();
	}
}
