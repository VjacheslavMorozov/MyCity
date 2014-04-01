package org.hillel.it.mycity.persistence.repository;

import java.util.List;

import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;

public interface EstablishmentRepository {
	
	public void addEstablishmentCinema(Cinema cinema);
	public void addEstablishmentNightClub(NightClub nightClub);
	public void addEstablishmentRestaurant(Restaurant restaurant);
	public Cinema getEstablishmentCinemaById(int id);
	public NightClub getEstablishmentNightClubById(int id);
	public Restaurant getEstablishmentRestaurantById(int id);
	public List<Cinema> getAllCinemaEstablishment();
	public List<NightClub> getAllNightClubEstablishment();
	public List<Restaurant> getAllRestaurantEstablishment();
	public void deleteAllCinemaEstablishments();
	public void deleteAllNightClubEstablishments();
	public void deleteAllRestaurantEstablishments();
	public void deleteAllEstablishments();
	public void deleteEstablishmentById(int id);
	
}
