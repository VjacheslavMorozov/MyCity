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
	private Map<Integer, String> estbalishmentMap;
	private int maxId;
	
	public InMemoryEstablishmentRepository() {
		cinemas = new ArrayList<>();
		nightClubs = new ArrayList<>();
		restaurants = new ArrayList<>();
		estbalishmentMap = new HashMap<Integer, String>();
		maxId = 1;
	}
	
	@Override
	public void addCinema(Cinema cinema) {
		validEstablishment(cinema);
		estbalishmentMap.put(maxId, "Cinema");
		cinema.setId(maxId++);
		cinemas.add(Objects.requireNonNull(cinema, "This object does not cointains any information"));
	}

	@Override
	public void addNightClub(NightClub nightClub) {
		validEstablishment(nightClub);
		estbalishmentMap.put(maxId, "NightClub");
		nightClub.setId(maxId++);
		nightClubs.add(Objects.requireNonNull(nightClub, "This object does not cointains any information"));
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		validEstablishment(restaurant);
		estbalishmentMap.put(maxId, "Restaurant");
		restaurant.setId(maxId++);
		restaurants.add(Objects.requireNonNull(restaurant, "This object does not cointains any information"));
	}

	@Override
	public List<Cinema> getCinemas() {
		return Collections.unmodifiableList(cinemas);
	}

	@Override
	public List<NightClub> getNightClubs() {
		return Collections.unmodifiableList(nightClubs);
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return Collections.unmodifiableList(restaurants);
	}
	
	@Override
	public void deleteEstablishment(int id) {
		validId(id);
		switch (estbalishmentMap.get(id)) {
		case "Cinema":
			establishmentNotNull(cinemas);
			Iterator<Cinema> iteratorCinemas = cinemas.iterator();
			while (iteratorCinemas.hasNext()) {
				if(iteratorCinemas.next().getId() == id) {
					iteratorCinemas.remove();
					estbalishmentMap.remove(id);
					break;
				}
			}
			break;
		case "NightClub":
			establishmentNotNull(nightClubs);
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
			establishmentNotNull(restaurants);
			Iterator<Restaurant> iteratorRestaurants = restaurants.iterator();
			while (iteratorRestaurants.hasNext()) {
				if(iteratorRestaurants.next().getId() == id) {
					iteratorRestaurants.remove();
					estbalishmentMap.remove(id);
					return;
				}
			}
			break;
		}
		
	}

	@Override
	public void deleteEstablishments() {
		cinemas.clear();
		nightClubs.clear();
		restaurants.clear();
	}

	@Override
	public Cinema getCinema(int id) {
		validId(id);
		establishmentNotNull(cinemas);
		for(Cinema cinema : cinemas) {
			if(cinema.getId() == id) {
				return cinema;
			}
		}
		return null;
	}

	@Override
	public Restaurant getRestaurant(int id) {
		validId(id);
		establishmentNotNull(restaurants);
		for(Restaurant restaurant : restaurants) {
			if(restaurant.getId() == id) {
				return restaurant;
			}
		}
		return null;
	}

	@Override
	public NightClub getNightClub(int id) {
		validId(id);
		establishmentNotNull(nightClubs);
		for(NightClub nightClub : nightClubs) {
			if(nightClub.getId() == id) {
				return nightClub;
			}
		}
		return null;
	}

	@Override
	public void deleteCinemas() {
		cinemas.clear();
	}

	@Override
	public void deleteNightClubs() {
		nightClubs.clear();
	}

	@Override
	public void deleteRestaurants() {
		restaurants.clear();
	}
	
	public void validEstablishment(Establishment establishment) {
		if(establishment.getId() > 0) {
			throw new RuntimeException("This establishment is already exist in memory");
		}
	}
	
	public void validId(int id) {
		if(id < 1 && !estbalishmentMap.containsKey(id)) {
			throw new RuntimeException("Incorrect id");
		}
	}
	
	public <T extends List>void establishmentNotNull(T t) {
		if(t.isEmpty()) {
			throw new NullPointerException("Array list is empty");
		}
	}
}
