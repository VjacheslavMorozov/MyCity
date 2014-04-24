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
	private static Administrator administrator;
	private int id;
	
	@BeforeClass
	public static void beforeClass() {
		inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		inMemoryUserRepository = new InMemoryUserRepository();
		inMemoryCommentRepository = new InMemoryCommentRepository();
		inMemoryAssessmentRepository = new InMemoryAssessmentRepository();
		serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, inMemoryUserRepository, inMemoryCommentRepository, inMemoryAssessmentRepository);
	}
	
	@Before
	public void beforeTest() { 
		serviceImpl.addAdministrator(new Administrator("mymail@mail.com", "world"));
		administrator = serviceImpl.getAdministrator(1);
		serviceImpl.setLoggedUser(administrator);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void addRestaurantTest() {
		serviceImpl.addRestaurant(administrator.createEstablishmentRestaurant());
	}
	
	@Test
	public void addCinemaTest() {
		serviceImpl.addCinema(administrator.createEstablishmentCinema());
	}
	
	@Test
	public void addNightClubTest() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
	}
	
	@Test
	public void deleteEstalbishmentsTest() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		serviceImpl.deleteEstablishments();
	}
	
	@Test
	public void deleteEstablishment() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		serviceImpl.deleteEstablishment(1);
	}
	
	@Test
	public void getCinemas() {
		serviceImpl.addCinema(administrator.createEstablishmentCinema());
		assertNotNull(serviceImpl.getCinemas());
	}
	
	@Test
	public void getNightClubs() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		assertNotNull(serviceImpl.getNightClubs());
	}
	
	@Test
	public void getRestaurants() {
		serviceImpl.addRestaurant(administrator.createEstablishmentRestaurant());
		assertNotNull(serviceImpl.getRestaurants());
	}
	
	@Test
	public void getCinema() {
		serviceImpl.addCinema(administrator.createEstablishmentCinema());
		assertNotNull(serviceImpl.getCinema(1));
	}
	
	@Test
	public void getNightClub() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		assertNotNull(serviceImpl.getNightClub(1));
	}
	
	@Test
	public void getRestaurant() {
		serviceImpl.addRestaurant(administrator.createEstablishmentRestaurant());
		assertNotNull(serviceImpl.getRestaurant(1));
	}
}