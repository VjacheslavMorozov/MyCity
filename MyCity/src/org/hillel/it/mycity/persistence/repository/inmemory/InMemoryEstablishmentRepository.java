package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.List;
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
	private int maxId;
	
	public InMemoryEstablishmentRepository() {
		cinemas = new ArrayList<>();
		nightClubs = new ArrayList<>();
		restaurants = new ArrayList<>();
		maxId = 1;
	}
	
	@Override
	public void addEstablishmentCinema(Cinema cinema) {
		if(cinema.getId() > 0) {
			System.out.println("This assessment is already exist in memory");
			return;
		}
		cinema.setId(maxId++);
		cinemas.add(Objects.requireNonNull(cinema, "This object does not cointains any information"));
	}

	@Override
	public void addEstablishmentNightClub(NightClub nightClub) {
		if(nightClub.getId() > 0) {
			System.out.println("This assessment is already exist in memory");
			return;
		}
		nightClub.setId(maxId++);
		nightClubs.add(Objects.requireNonNull(nightClub, "This object does not cointains any information"));
	}

	@Override
	public void addEstablishmentRestaurant(Restaurant restaurant) {
		if(restaurant.getId() > 0) {
			System.out.println("This assessment is already exist in memory");
			return;
		}
		restaurant.setId(maxId++);
		restaurants.add(Objects.requireNonNull(restaurant, "This object does not cointains any information"));
	}
	
	public <T> T getEstablishmentById(int id, Class<T> type) {
		
		if(id < 1) {
			System.out.println("Incorrect id");
			return null;
		}
		if(type.toString().contains("Cinema")) {
			if(cinemas.isEmpty()) {
				System.out.println("Cinema array is empty");
				return null;
			}
			for(int i = 0; i < cinemas.size(); i++) {
				if(cinemas.get(i).getId() == id) {
					return type.cast(cinemas.get(i));
				}
			}
		} else if(type.toString().contains("NightClub")) {
			if(nightClubs.isEmpty()) {
				System.out.println("Night Club array is empty");
				return null;
			}
			for(int i = 0; i < nightClubs.size(); i++) {
				if(nightClubs.get(i).getId() == id) {
					return type.cast(nightClubs.get(i));	
				}
			}
		} else if(type.toString().contains("Restaurant")){
			if(restaurants.isEmpty()) {
				System.out.println("Restaurant array is empty");
				return null;
			}
			for(int i = 0; i < restaurants.size(); i++) {
				if(restaurants.get(i).getId() == id) {
					return type.cast(restaurants.get(i));
				}
			}
		}
		return null;
	}

	@Override
	public List<Cinema> getAllCinemaEstablishment() {
		
		if(cinemas.isEmpty()) {
			return null;
		}
		return cinemas;
		
	}

	@Override
	public List<NightClub> getAllNightClubEstablishment() {
		if(nightClubs.isEmpty()) {
			return null;
		}
		return nightClubs;
	}

	@Override
	public List<Restaurant> getAllRestaurantEstablishment() {
		if(restaurants.isEmpty()) {
			return null;
		}
		return restaurants;
	}

	@Override
	public void deleteEstablishmentByType(String establishmentType) {
		String type = establishmentType.toUpperCase(); 
		
		switch (type) {
		case "CINEMA":
			cinemas.clear();
			break;
		case "NIGHTCLUB":
			nightClubs.clear();
			break;
		case "RESTAURANT":
			restaurants.clear();
			break;
		default:
			System.out.println("No such type of establishment");
			break;
		}
		
	}
	
	@Override
	public void deleteEstablishmentById(int id) {
		
		if (id <= 0)  {
			System.out.println("List is empty");
			return;
		} else if(cinemas.isEmpty() && nightClubs.isEmpty() && restaurants.isEmpty()){
			System.out.println("Incorrect id");
			return;
		}
		
		int maxIndex = 0;
		if(cinemas.size() > nightClubs.size() && cinemas.size() > restaurants.size()){
			maxIndex = cinemas.size();
		} else if(nightClubs.size() > restaurants.size() && nightClubs.size() > cinemas.size()) {
			maxIndex = nightClubs.size();
		} else {
			maxIndex = restaurants.size();
		}
		
		for(int i = 0; i < maxIndex; i++) {
			if(i < cinemas.size()) {
				if(cinemas.get(i).getId() == id) {
					cinemas.remove(i);
					System.out.println("Cinema has been removed by index - " + id);
					return;
				}
			}
			if(i < nightClubs.size()) {
				if(nightClubs.get(i).getId() == id) {
					nightClubs.remove(i);
					System.out.println("NightClub has been removed by index - " + id);
					return;
				}
			}
			if(i < restaurants.size()) {
				if(restaurants.get(i).getId() == id) {
					restaurants.remove(i);
					System.out.println("Restaurant has been removed by index - " + id);
					return;
				}
			}
			
		}
	}

	@Override
	public void deleteAllEstablishments() {
		
		cinemas.clear();
		nightClubs.clear();
		restaurants.clear();
		
	}
}
