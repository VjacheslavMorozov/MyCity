package org.hillel.it.mycity.service;

import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.model.entity.User;

public interface ServiceMyCity {
	//Establishment repository
	public void addEstablishmentRestaurant(Administrator administrator);
	public void addEstablishmentNightClub(Administrator administrator);
	public void addEstablishmentCinema(Administrator administrator);
	public List<Cinema> getAllCinemaEstablishment();
	public List<NightClub> getAllNightClubEstablishment();
	public List<Restaurant> getAllRestaurantEstablishment();
	public void deleteAllEstablishments();
	public void deleteEstablishmentById(int id);
	public Cinema getCinemaEstablishmentById(int id);
	public NightClub getNightClubEstablishmentById(int id);
	public Restaurant getRestaurantEstablishmentById(int id);
	public void deleteEstablishmentByType(String establishmentType);
	
	//User repository
	public void addAdministrator(Administrator administrator);
	public void addModerator(Administrator administrator);
	public void addUser(Administrator administrator);
	public List<Administrator> getAllAdministrators();
	public List<Moderator> getAllModerators();
	public List<User> getAllUsers();
	public void deleteAllUsers();
	public void deleteUserById(int id);
	public Administrator getAdministratorById(int id);
	public Moderator getModeratorById(int id);
	public User getUserById(int id);
	
}
