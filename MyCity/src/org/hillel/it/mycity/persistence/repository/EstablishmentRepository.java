package org.hillel.it.mycity.persistence.repository;

import java.util.List;

import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;

public interface EstablishmentRepository {
	
	public void addEstablishmentCinema(Cinema cinema);
	public void addEstablishmentNightClub(NightClub nightClub);
	public void addEstablishmentRestaurant(Restaurant restaurant);
	public Cinema getCinema(int id);
	public Restaurant getRestaurant(int id);
	public NightClub getNightClub(int id);
	public List<Cinema> getAllCinemaEstablishment();
	public List<NightClub> getAllNightClubEstablishment();
	public List<Restaurant> getAllRestaurantEstablishment();
	public void deleteCinemas();
	public void deleteNightClubs();
	public void deleteRestaurants();
	public void deleteAllEstablishments();
	public void deleteEstablishment(int id);
	
}
