package org.hillel.it.mycity.service;

import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.Restaurant;

public interface ServiceMyCity {
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
}
