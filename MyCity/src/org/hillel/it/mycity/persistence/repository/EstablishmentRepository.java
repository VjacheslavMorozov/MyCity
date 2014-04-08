package org.hillel.it.mycity.persistence.repository;

import java.util.List;

import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;

public interface EstablishmentRepository {
	
	public void addEstablishmentCinema(Cinema cinema);
	public void addEstablishmentNightClub(NightClub nightClub);
	public void addEstablishmentRestaurant(Restaurant restaurant);
	public List<Cinema> getAllCinemaEstablishment();
	public List<NightClub> getAllNightClubEstablishment();
	public List<Restaurant> getAllRestaurantEstablishment();
	public void deleteEstablishmentByType(String establishmentType);
	public void deleteAllEstablishments();
	public void deleteEstablishmentById(int id);
	public <T> T getEstablishmentById(int id, Class<T> type);
	public int getLastId();
}
