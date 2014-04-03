package org.hillel.it.mycity.service;

import java.util.List;

import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;

public interface ServiceMyCity {
	public void addEstablishmentRestaurant(String nameOfEstablishment,String addressOfEstablishment);
	public void addEstablishmentNightClub(String nameOfEstablishment,String addressOfEstablishment);
	public void addEstablishmentCinema(String nameOfEstablishment,String addressOfEstablishment);
	public List<Cinema> getAllCinemaEstablishment();
	public List<NightClub> getAllNightClubEstablishment();
	public List<Restaurant> getAllRestaurantEstablishment();
	public void deleteAllEstablishments();
	public void deleteEstablishmentById(int id);
	public <T> T getEstablishmentById(int id, Class<T> type);
	public void deleteEstablishmentByType(String establishmentType);
}
