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
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryUserRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


public class ServiceImplTest {
	private static ServiceImpl serviceImpl;
	private static EstablishmentRepository inMemoryEstablishmentRepository;
	private static UserRepository inMemoryUserRepository;
	private List<Cinema> cinemaList;
	private List<Restaurant> restaurantList;
	private List<NightClub> nightClubList;
	private static Person loggedPerson;
	private static String username;
	private static String password;
	
	@BeforeClass
	public static void beforeTest() {
		username = "EnteredUsername";
		password = "EnteredPassword";
		loggedPerson = Person.logIn(username, password);
		loggedPerson.setGroup(Group.Administrator);
		inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		inMemoryUserRepository = new InMemoryUserRepository();
		serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, inMemoryUserRepository, loggedPerson);
	}
	
	@Test
	public void addEstablishmentRestaurantTest() {
		Administrator administrator = new Administrator();
		serviceImpl.addEstablishmentRestaurant(administrator.addEstablishmentRestaurant());
		serviceImpl.addAdministrator(administrator);
		Restaurant restaurant = new Restaurant();
		restaurant = administrator.addEstablishmentRestaurant();
		restaurant.setAddressOfEstablishment("His address");
		restaurant.setNameOfEstablishment("His name");
		restaurant.setTelephoneOfEstablishment("0638678900");
		serviceImpl.addEstablishmentRestaurant(restaurant);
		restaurant = serviceImpl.getRestaurantEstablishmentById(1);
		System.out.println(restaurant.getAddressOfEstablishment());
	}
	/*
	@Test
	public void addEstablishmentNightClubTest() {
		
	}
	
	@Test
	public void addEstablishmentCinemaTest() {
		System.out.println("Add Restaurant:");
		serviceImpl.addEstablishmentCinema(administrator);
		administrator.setLogin("login");
		serviceImpl.addEstablishmentCinema(administrator);
	}
	
	@Test
	public void getAllCinemaEstablishmentTest() {
		System.out.println("Get all Cinema:");
		administrator.setLogin("login");
		cinemaList = new ArrayList<>();
		assertNull(cinemaList = serviceImpl.getAllCinemaEstablishment());
		serviceImpl.addEstablishmentCinema(administrator);
		cinemaList = serviceImpl.getAllCinemaEstablishment();
	}
	
	@Test
	public void getAllNightClubEstablishmentTest() {
		System.out.println("Get all NightClub:");
		administrator.setLogin("login");
		nightClubList = new ArrayList<>();
		assertNull(nightClubList = serviceImpl.getAllNightClubEstablishment());
		serviceImpl.addEstablishmentNightClub(administrator);
		nightClubList = serviceImpl.getAllNightClubEstablishment();
	}
	
	@Test
	public void getAllRestaurantEstablishmentTest() {
		System.out.println("Get all Restaurant:");
		administrator.setLogin("login");
		restaurantList = new ArrayList<>();
		assertNull(restaurantList = serviceImpl.getAllRestaurantEstablishment());
		serviceImpl.addEstablishmentRestaurant(administrator);
		restaurantList = serviceImpl.getAllRestaurantEstablishment();
	}
	
	@Test
	public void deleteAllEstablishmentsTest() {
		System.out.println("Delete all:");
		administrator.setLogin("login");
		serviceImpl.addEstablishmentCinema(administrator);
		serviceImpl.addEstablishmentNightClub(administrator);
		serviceImpl.addEstablishmentRestaurant(administrator);
		serviceImpl.deleteAllEstablishments();
	}
	
	@Test
	public void deleteEstablishmentByIdTest() {
		System.out.println("Delete by Id:");
		administrator.setLogin("login");
		serviceImpl.deleteEstablishmentById(0);
		serviceImpl.deleteEstablishmentById(1);
		serviceImpl.addEstablishmentCinema(administrator);
		serviceImpl.addEstablishmentNightClub(administrator);
		serviceImpl.addEstablishmentRestaurant(administrator);
		serviceImpl.deleteEstablishmentById(serviceImpl.getLastId() - 3);
		serviceImpl.addEstablishmentCinema(administrator);
		serviceImpl.addEstablishmentCinema(administrator);
		serviceImpl.deleteEstablishmentById(serviceImpl.getLastId() - 4);
		serviceImpl.addEstablishmentNightClub(administrator);
		serviceImpl.addEstablishmentNightClub(administrator);
		serviceImpl.deleteEstablishmentById(serviceImpl.getLastId() - 5);
		serviceImpl.addEstablishmentRestaurant(administrator);
		serviceImpl.addEstablishmentRestaurant(administrator);
		serviceImpl.addEstablishmentNightClub(administrator);
		serviceImpl.addEstablishmentNightClub(administrator);
		serviceImpl.deleteEstablishmentById(serviceImpl.getLastId() - 8);
		
	}
	
	@Test
	public void getCinemaEstablishmentByIdTest() {
		System.out.println("Get Cinema by id:");
		administrator.setLogin("login");
		assertNull(serviceImpl.getCinemaEstablishmentById(0));
		assertNull(serviceImpl.getCinemaEstablishmentById(serviceImpl.getLastId() + 1));
		serviceImpl.addEstablishmentCinema(administrator);
		serviceImpl.getCinemaEstablishmentById(serviceImpl.getLastId() - 1);
	}
	
	@Test
	public void getNightClubEstablishmentByIdTest() {
		System.out.println("Get Night Club by id:");
		administrator.setLogin("login");
		assertNull(serviceImpl.getNightClubEstablishmentById(serviceImpl.getLastId() + 1));
		serviceImpl.addEstablishmentNightClub(administrator);
		serviceImpl.getNightClubEstablishmentById(serviceImpl.getLastId() - 1);
	}
	
	@Test
	public void getRestaurantEstablishmentByIdTest() {
		System.out.println("Get Restaurant by id:");
		administrator.setLogin("login");
		assertNull(serviceImpl.getRestaurantEstablishmentById(serviceImpl.getLastId() + 1));
		serviceImpl.addEstablishmentRestaurant(administrator);
		serviceImpl.getRestaurantEstablishmentById(serviceImpl.getLastId() - 1);
	}
	
	@Test
	public void deleteEstablishmentByTypeTest() {
		System.out.println("Delete establishment by type:");
		serviceImpl.deleteEstablishmentByType("cinema");
		serviceImpl.deleteEstablishmentByType("restaurant");
		serviceImpl.deleteEstablishmentByType("nightclub");
		serviceImpl.deleteEstablishmentByType("cafe");
	}*/
}
