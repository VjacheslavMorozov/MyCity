package org.hillel.it.mycity.bootstrap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hillel.it.mycity.connectionpool.ConnectionPool;
import org.hillel.it.mycity.connectionpool.ReuseableConnectionPool;
import org.hillel.it.mycity.info.Configuration;
import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.AssessmentRepository;
import org.hillel.it.mycity.persistence.repository.CommentRepository;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.DataBaseEstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.FileUserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryAssessmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryCommentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryUserRepository;
import org.hillel.it.mycity.service.ServiceMyCity;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		UserRepository inMemoryUserRepository = new FileUserRepository();
		CommentRepository inMemoryCommentRepository = new InMemoryCommentRepository();
		AssessmentRepository inMemoryAssessmentRepository = new InMemoryAssessmentRepository();
		
		Configuration configuration = Configuration.getInstance();
		
		ConnectionPool cp = new ReuseableConnectionPool(configuration.getUrl(), configuration.getMaxConnCount());
		
		EstablishmentRepository databaseEstablishmentRepository = new DataBaseEstablishmentRepository(cp);
		ServiceMyCity serviceImpl = new ServiceImpl(databaseEstablishmentRepository, inMemoryUserRepository, inMemoryCommentRepository, inMemoryAssessmentRepository);
		
		Administrator administrator = new Administrator("mymail1@mail.com", "password");
		serviceImpl.addAdministrator(administrator);
		serviceImpl.setLoggedUser(administrator);
		Cinema cinema = administrator.createEstablishmentCinema();
		cinema.setAddressOfEstablishment("Test address3");
		cinema.setDescriptionOfEstablishment("Test description3");
		cinema.setNameOfEstablishment("Test name3");
		try {
			cinema.setTelephoneOfEstablishment("0677472072");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cinema.setCinemaTechnology("3D");
		cinema.setNumberOfHalls(2);
		cinema.setNumberOfSeatsInHall(500);
		serviceImpl.addCinema(cinema);
		cp.destroy();
	}
}
