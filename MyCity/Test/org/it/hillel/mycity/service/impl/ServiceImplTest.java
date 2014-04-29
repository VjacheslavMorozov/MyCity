package org.it.hillel.mycity.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.AssessmentRepository;
import org.hillel.it.mycity.persistence.repository.CommentRepository;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.FileUserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryAssessmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryCommentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryUserRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
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
	private static int userId;
	private static int establishmentId;
	private static String email;
	
	@BeforeClass
	public static void beforeClass() {
		inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		inMemoryUserRepository = new FileUserRepository();
		inMemoryCommentRepository = new InMemoryCommentRepository();
		inMemoryAssessmentRepository = new InMemoryAssessmentRepository();
		serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, inMemoryUserRepository, inMemoryCommentRepository, inMemoryAssessmentRepository);
		userId = establishmentId = 1;
		serviceImpl.addAdministrator(new Administrator("mymail@mail.com", "world"));
		administrator = serviceImpl.getAdministrator(1);
		serviceImpl.setLoggedUser(administrator);
		userId++;
	}
	
	@Before
	public void beforeTest() {
		email = "maymail" + userId + "@mail.com";
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void addRestaurantTest() {
		serviceImpl.addRestaurant(administrator.createEstablishmentRestaurant());
		establishmentId++;
	}
	
	@Test
	public void addCinemaTest() {
		serviceImpl.addCinema(administrator.createEstablishmentCinema());
		establishmentId++;
	}
	
	@Test
	public void addNightClubTest() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		establishmentId++;
	}
	
	@Test
	public void deleteEstalbishmentsTest() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		serviceImpl.deleteEstablishments();
		establishmentId++;
	}
	
	@Test
	public void deleteEstablishment() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		serviceImpl.deleteEstablishment(establishmentId);
		establishmentId++;
		serviceImpl.addCinema(administrator.createEstablishmentCinema());
		serviceImpl.deleteEstablishment(establishmentId);
		establishmentId++;
		serviceImpl.addRestaurant(administrator.createEstablishmentRestaurant());
		serviceImpl.deleteEstablishment(establishmentId);
		establishmentId++;
	}
	
	@Test
	public void getCinemas() {
		serviceImpl.addCinema(administrator.createEstablishmentCinema());
		assertNotNull(serviceImpl.getCinemas());
		establishmentId++;
	}
	
	@Test
	public void getNightClubs() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		assertNotNull(serviceImpl.getNightClubs());
		establishmentId++;
	}
	
	@Test
	public void getRestaurants() {
		serviceImpl.addRestaurant(administrator.createEstablishmentRestaurant());
		assertNotNull(serviceImpl.getRestaurants());
		establishmentId++;
	}
	
	@Test
	public void getCinema() {
		serviceImpl.addCinema(administrator.createEstablishmentCinema());
		assertNotNull(serviceImpl.getCinema(establishmentId));
		assertNotNull(serviceImpl.getCinema(establishmentId).getCreatedDate());
		establishmentId++;
	}
	
	@Test
	public void getNightClub() {
		serviceImpl.addNightClub(administrator.createEstablishmentNightClub());
		assertNotNull(serviceImpl.getNightClub(establishmentId));
		establishmentId++;
	}
	
	@Test
	public void getRestaurant() {
		serviceImpl.addRestaurant(administrator.createEstablishmentRestaurant());
		assertNotNull(serviceImpl.getRestaurant(establishmentId));
		establishmentId++;
	}
	
	@Test
	public void addModerator() {
		Moderator moderator = new Moderator(email, "password");
		serviceImpl.addModerator(moderator);
		userId++;
	}
	
	@Test
	public void addUser() {
		User user = new User(email, "password");
		serviceImpl.addUser(user);
		System.out.println(serviceImpl.getUser(userId).getUsername());
		userId++;
	}
	
	@Test
	public void getAdministrators() {
		Administrator administrator = new Administrator(email, "password");
		serviceImpl.addAdministrator(administrator);
		assertNotNull(serviceImpl.getAdministrators());
		userId++;
	}
	
	@Test
	public void getModerators() {
		Moderator moderator = new Moderator(email, "password");
		serviceImpl.addModerator(moderator);
		assertNotNull(serviceImpl.getModerators());
		userId++;
	}
	
	@Test
	public void getUsers() {
		User user = new User(email, "password");
		serviceImpl.addUser(user);
		assertNotNull(serviceImpl.getUsers());
		userId++;
	}
	
	@Test
	public void getAdministrator() {
		Administrator administrator = new Administrator(email, "password");
		serviceImpl.addAdministrator(administrator);
		assertNotNull(serviceImpl.getAdministrator(userId));
		userId++;
	}
	
	@Test
	public void getModerator() {
		Moderator moderator = new Moderator(email, "password");
		serviceImpl.addModerator(moderator);
		assertNotNull(serviceImpl.getModerator(userId));
		userId++;
	}
	
	@Test
	public void getUser() {
		User user = new User(email, "password");
		serviceImpl.addUser(user);
		assertNotNull(serviceImpl.getUser(userId));
		userId++;
	}
	
	@Test
	public void deleteUser() {
		Administrator administrator = new Administrator(email, "password");
		serviceImpl.addAdministrator(administrator);
		serviceImpl.deleteUser(userId);
		userId++;
		beforeTest();
		Moderator moderator = new Moderator(email, "password");
		serviceImpl.addModerator(moderator);
		serviceImpl.deleteUser(userId);
		userId++;
		beforeTest();
		User user = new User(email, "password");
		serviceImpl.addUser(user);
		serviceImpl.deleteUser(userId);
		userId++;
	}
	
	@Test
	public void addComment() {
		serviceImpl.addComment(administrator.createComment("Hello"));
	}
}