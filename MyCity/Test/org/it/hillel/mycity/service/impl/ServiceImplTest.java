package org.it.hillel.mycity.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


public class ServiceImplTest {
	private ServiceImpl serviceImpl;
	private EstablishmentRepository inMemoryEstablishmentRepository;
	private List<Cinema> cinemaList;
	private List<Restaurant> restaurantList;
	private List<NightClub> nightClubList;
	private Administrator administrator;
	
	@Before
	public void beforeTest() {
		inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository);
		administrator = new Administrator(null);
		System.out.println('\n' + "Befor Test");
	}
	
	@Test
	public void addEstablishmentRestaurantTest() {
		System.out.println("Add Restaurant:");
		serviceImpl.addEstablishmentRestaurant(administrator);
		administrator.setLogin("login");
		serviceImpl.addEstablishmentRestaurant(administrator);
	}
	
	@Test
	public void addEstablishmentNightClubTest() {
		System.out.println("Add Night Club:");
		serviceImpl.addEstablishmentNightClub(administrator);
		administrator.setLogin("login");
		serviceImpl.addEstablishmentNightClub(administrator);
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
	}
}
