package org.it.hillel.mycity.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.persistence.repository.AssessmentRepository;
import org.hillel.it.mycity.persistence.repository.CommentRepository;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryAssessmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryCommentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryUserRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;


public class ServiceImplTest {
	private static ServiceImpl serviceImpl;
	private static EstablishmentRepository inMemoryEstablishmentRepository;
	private static UserRepository inMemoryUserRepository;
	private static CommentRepository inMemoryCommentRepository;
	private static AssessmentRepository inMemoryAssessmentRepository;
	
	@BeforeClass
	public static void beforeTest() {
		inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		inMemoryUserRepository = new InMemoryUserRepository();
		inMemoryCommentRepository = new InMemoryCommentRepository();
		inMemoryAssessmentRepository = new InMemoryAssessmentRepository();
		serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, inMemoryUserRepository, inMemoryCommentRepository, inMemoryAssessmentRepository);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void addRestaurantTest() {
		serviceImpl.addAdministrator(new Administrator("mymail1@mail.com", "world"));
		Administrator administrator1 = serviceImpl.getAdministrator(1);
		serviceImpl.setLoggedUser(administrator1);
		serviceImpl.addRestaurant(administrator1.createEstablishmentRestaurant());
	}
	
	@Test
	public void addCinemaTest() {
		serviceImpl.addAdministrator(new Administrator("mymail2@mail.com", "world"));
		Administrator administrator = serviceImpl.getAdministrator(1);
		serviceImpl.setLoggedUser(administrator);
		serviceImpl.addCinema(administrator.createEstablishmentCinema());
	}
	
	@Test
	public void addNightClubTest() {
		serviceImpl.addAdministrator(new Administrator("mymail3@mail.com", "world"));
		Administrator administrator = serviceImpl.getAdministrator(1);
		serviceImpl.setLoggedUser(administrator);
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
	}
	
	@Test
	public void deleteEstalbishmentsTest() {
		serviceImpl.addAdministrator(new Administrator("mymail4@mail.com", "world"));
		Administrator administrator = serviceImpl.getAdministrator(1);
		serviceImpl.setLoggedUser(administrator);
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		serviceImpl.deleteEstablishments();
	}
}