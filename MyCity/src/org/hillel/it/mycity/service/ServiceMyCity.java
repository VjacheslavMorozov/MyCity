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
	// CREATE Establishment
	/* @timur Тут можно попробовать реализовать шаблон FactoryMethod.
	 * Тогда будет всего один метод типа
	 * public void addEstablishment(EstType estType), 
	 * где EstType - перечисление Restaurant, NightClub, Cinema.
	 * 
	 * Параметр Administrator administrator надо убирать и менять реализацию.
	 * В системе будет существовать объект типа Person person, который будет содержать инфу
	 * о залогинившемся пользователе. Реализация метода addEstablishmentRestaurant
	 * будет обращаться к методу person.inGroup("admin"). 
	 * 
	 */ 
	public void addEstablishmentRestaurant();
	public void addEstablishmentNightClub(Administrator administrator);
	public void addEstablishmentCinema(Administrator administrator);
	
	// READ Establishment
	public List<Cinema> getAllCinemaEstablishment();
	public List<NightClub> getAllNightClubEstablishment();
	public List<Restaurant> getAllRestaurantEstablishment();
	
	public Cinema getCinemaEstablishmentById(int id);
	public NightClub getNightClubEstablishmentById(int id);
	public Restaurant getRestaurantEstablishmentById(int id);

	// UPDATE Establishment
	// @timur need to add update Establishment methods

	// DELETE Establishment
	public void deleteAllEstablishments();
	public void deleteEstablishmentById(int id);
	public void deleteEstablishmentByType(String establishmentType);
	
	// Person repository
	// CREATE Person
	public void addAdministrator(Administrator administrator);
	public void addModerator(Administrator administrator);
	public void addUser(Administrator administrator);

	// READ Person
	public List<Administrator> getAllAdministrators();
	public List<Moderator> getAllModerators();
	public List<User> getAllUsers();

	public Administrator getAdministratorById(int id);
	public Moderator getModeratorById(int id);
	public User getUserById(int id);

	// UPDATE Person
	// @timur need to add update Person methods

	// DELETE Person
	public void deleteAllUsers();
	public void deleteUserById(int id);
	
}
