package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.hillel.it.mycity.model.entity.BaseEntity;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;

public class InMemoryEstablishmentRepository implements EstablishmentRepository{
	private List<Cinema> cinemas;
	private List<NightClub> nightClubs;
	private List<Restaurant> restaurants;
	private List<Cinema> unmodifiableCinemas;
	private List<NightClub> unmodifiableNightClubs;
	private List<Restaurant> unmodifiableRestaurants;
	private Map<Integer, String> estbalishmentMap;
	private int maxId;
	
	public InMemoryEstablishmentRepository() {
		cinemas = new ArrayList<>();
		nightClubs = new ArrayList<>();
		restaurants = new ArrayList<>();
		unmodifiableCinemas = Collections.unmodifiableList(cinemas);
		unmodifiableNightClubs = Collections.unmodifiableList(nightClubs);
		unmodifiableRestaurants = Collections.unmodifiableList(restaurants);
		estbalishmentMap = new HashMap<Integer, String>();
		maxId = 1;
	}
	
	@Override
	public void addEstablishmentCinema(Cinema cinema) {
		if(!validEstablishment(cinema)) {
			throw new RuntimeException("This establishment is already exist in memory");
		}
		estbalishmentMap.put(maxId, "Cinema");
		cinema.setId(maxId++);
		cinemas.add(Objects.requireNonNull(cinema, "This object does not cointains any information"));
	}

	@Override
	public void addEstablishmentNightClub(NightClub nightClub) {
		if(!validEstablishment(nightClub)) {
			throw new RuntimeException("This establishment is already exist in memory");
		}
		estbalishmentMap.put(maxId, "NightClub");
		nightClub.setId(maxId++);
		nightClubs.add(Objects.requireNonNull(nightClub, "This object does not cointains any information"));
	}

	@Override
	public void addEstablishmentRestaurant(Restaurant restaurant) {
		if(!validEstablishment(restaurant)) {
			throw new RuntimeException("This establishment is already exist in memory");
		}
		estbalishmentMap.put(maxId, "Restaurant");
		restaurant.setId(maxId++);
		restaurants.add(Objects.requireNonNull(restaurant, "This object does not cointains any information"));
	}
	
	public boolean validEstablishment(Establishment establishment) {
		if(establishment.getId() > 0) {
			return false;
		}
		return true;
	}
	
	public boolean validId(int id) {
		if(id < 1) {
			return false;
		}
		return true;
	}

	@Override
	public List<Cinema> getAllCinemaEstablishment() {
		return unmodifiableCinemas;
		
	}

	@Override
	public List<NightClub> getAllNightClubEstablishment() {
		return unmodifiableNightClubs;
	}

	@Override
	public List<Restaurant> getAllRestaurantEstablishment() {
		return unmodifiableRestaurants;
	}
	
	@Override
	public void deleteEstablishment(int id) {
		if(!validId(id)) {
			throw new RuntimeException("Incorrect Id");
		}
		switch (estbalishmentMap.get(id)) {
		case "Cinema":
			Iterator<Cinema> iteratorCinemas = cinemas.iterator();
			while (iteratorCinemas.hasNext()) {
				if(iteratorCinemas.next().getId() == id) {
					iteratorCinemas.remove();
					estbalishmentMap.remove(id);
					return;
				}
			}
			break;
		case "NightClub":
			Iterator<NightClub> iteratorNightClubs = nightClubs.iterator();
			while (iteratorNightClubs.hasNext()) {
				if(iteratorNightClubs.next().getId() == id) {
					iteratorNightClubs.remove();
					estbalishmentMap.remove(id);
					return;
				}
			}
			break;
		case "Restaurant":
			Iterator<Restaurant> iteratorRestaurants = restaurants.iterator();
			while (iteratorRestaurants.hasNext()) {
				if(iteratorRestaurants.next().getId() == id) {
					iteratorRestaurants.remove();
					estbalishmentMap.remove(id);
					return;
				}
			}
			break;
		default:
			throw new RuntimeException("There is no such id");
			break;
		}
		
	}

	@Override
	public void deleteAllEstablishments() {
		cinemas.clear();
		nightClubs.clear();
		restaurants.clear();
	}

	@Override
	public Cinema getCinema(int id) {
		for(Cinema cinema : cinemas) {
			if(cinema.getId() == id) {
				return cinema;
			}
		}
		return null;
	}

	@Override
	public Restaurant getRestaurant(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NightClub getNightClub(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCinemas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNightClubs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRestaurants() {
		// TODO Auto-generated method stub
		
	}
}
