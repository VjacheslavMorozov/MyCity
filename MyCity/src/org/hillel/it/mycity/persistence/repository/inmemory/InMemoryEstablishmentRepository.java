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
	public void addCinema(Cinema cinema) {
		if(!validEstablishment(cinema)) {
			throw new RuntimeException("This establishment is already exist in memory");
		}
		estbalishmentMap.put(maxId, "Cinema");
		cinema.setId(maxId++);
		cinemas.add(Objects.requireNonNull(cinema, "This object does not cointains any information"));
	}

	@Override
	public void addNightClub(NightClub nightClub) {
		if(!validEstablishment(nightClub)) {
			throw new RuntimeException("This establishment is already exist in memory");
		}
		estbalishmentMap.put(maxId, "NightClub");
		nightClub.setId(maxId++);
		nightClubs.add(Objects.requireNonNull(nightClub, "This object does not cointains any information"));
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
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
	
	public void validId(int id) {
		if(id < 1) {
			throw new RuntimeException("Incorrect id");
		}
	}

	@Override
	public List<Cinema> getCinemas() {
		return unmodifiableCinemas;
	}

	@Override
	public List<NightClub> getNightClubs() {
		return unmodifiableNightClubs;
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return unmodifiableRestaurants;
	}
	
	@Override
	public void deleteEstablishment(int id) {
		try {
			validId(id);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		switch (estbalishmentMap.get(id)) {
		case "Cinema":
			try {
				Objects.requireNonNull(cinemas);
				Iterator<Cinema> iteratorCinemas = cinemas.iterator();
				while (iteratorCinemas.hasNext()) {
					if(iteratorCinemas.next().getId() == id) {
						iteratorCinemas.remove();
						estbalishmentMap.remove(id);
						break;
					}
				}
			} catch (NullPointerException e) {
				System.out.println(e);
				throw new NullPointerException();
			}
			break;
		case "NightClub":
			try {
				Objects.requireNonNull(nightClubs);
				Iterator<NightClub> iteratorNightClubs = nightClubs.iterator();
				while (iteratorNightClubs.hasNext()) {
					if(iteratorNightClubs.next().getId() == id) {
						iteratorNightClubs.remove();
						estbalishmentMap.remove(id);
						return;
					}
				}
			} catch (NullPointerException e) {
				System.out.println(e);
				throw new NullPointerException();
			}
			break;
		case "Restaurant":
			try {
				Objects.requireNonNull(restaurants);
				Iterator<Restaurant> iteratorRestaurants = restaurants.iterator();
				while (iteratorRestaurants.hasNext()) {
					if(iteratorRestaurants.next().getId() == id) {
						iteratorRestaurants.remove();
						estbalishmentMap.remove(id);
						return;
					}
				}
			} catch (NullPointerException e) {
				System.out.println(e);
				throw new NullPointerException();
			}
			break;
		default:
			throw new RuntimeException("There is no such id");
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
		try {
			validId(id);
			Objects.requireNonNull(cinemas);
			for(Cinema cinema : cinemas) {
				if(cinema.getId() == id) {
					return cinema;
				}
			}
		} catch (NullPointerException e) {
			throw new NullPointerException("Array list is empty");
		} catch (RuntimeException e) {
			throw new RuntimeException("Incorrect id");
		}
		return null;
	}

	@Override
	public Restaurant getRestaurant(int id) {
		try {
			validId(id);
			Objects.requireNonNull(restaurants);
			for(Restaurant restaurant : restaurants) {
				if(restaurant.getId() == id) {
					return restaurant;
				}
			}
		} catch (NullPointerException e) {
			throw new NullPointerException("Array list is empty");
		} catch (RuntimeException e) {
			throw new RuntimeException("Incorrect id");
		}
		return null;
	}

	@Override
	public NightClub getNightClub(int id) {
		try {
			validId(id);
			Objects.requireNonNull(nightClubs);
			for(NightClub nightClub : nightClubs) {
				if(nightClub.getId() == id) {
					return nightClub;
				}
			}
		} catch (NullPointerException e) {
			throw new NullPointerException("Array list is empty");
		} catch (RuntimeException e) {
			throw new RuntimeException("Incorrect id");
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
}
