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
	
	public InMemoryEstablishmentRepository() {
		
		cinemas = new ArrayList<>();
		nightClubs = new ArrayList<>();
		restaurants = new ArrayList<>();
		
	}
	
	@Override
	public void addEstablishmentCinema(Cinema cinema) {
		
		cinemas.add(cinema);
		
	}

	@Override
	public void addEstablishmentNightClub(NightClub nightClub) {
		
		nightClubs.add(nightClub);
		
	}

	@Override
	public void addEstablishmentRestaurant(Restaurant restaurant) {
		
		restaurants.add(restaurant);
		
	}
	
	public <T> T getEstablishmentById(int id, Class<T> type) {
		
		if(id <= 0) {
			
			System.out.println("Incorrect id");
			return null;
			
		}
		if(type.toString().contains("Cinema")) {
			
			for(int i = 0; i < cinemas.size(); i++) {
				System.out.println(cinemas.get(i).getId());
				
				if(cinemas.get(i).getId() == id) {
					
					return type.cast(cinemas.get(i));
					
				}
				
			}
			
		} else if(type.toString().contains("NightClub")) {
			
			for(int i = 0; i < nightClubs.size(); i++) {
				
				if(nightClubs.get(i).getId() == id) {
					
					return type.cast(nightClubs.get(i));
					
				}
				
			}
		} else {
			
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
			
			System.out.println("List of Cinemas is epmty");
			return null;
			
		}
		return cinemas;
		
	}

	@Override
	public List<NightClub> getAllNightClubEstablishment() {
		
		if(nightClubs.isEmpty()) {
			
			System.out.println("List of Night Clubs is epmty");
			return null;
			
		}
		return nightClubs;
		
	}

	@Override
	public List<Restaurant> getAllRestaurantEstablishment() {
		
		if(restaurants.isEmpty()) {
			
			System.out.println("List of Restaurants is epmty");
			return null;
			
		}
		return restaurants;
		
	}

	@Override
	public void deleteEstablishmentByType(String establishmentType) {
		establishmentType.toUpperCase(); 
		
		switch (establishmentType) {
		case "CINEMA":
			cinemas.clear();
			break;
		case "NIGHTCLUBS":
			nightClubs.clear();
			break;
		case "RESTAURANT":
			restaurants.clear();
		default:
			System.out.println("No such type of establishment");
			break;
		}
		
	}
	
	@Override
	public void deleteEstablishmentById(int id) {
		
		if(cinemas.isEmpty() && nightClubs.isEmpty() && restaurants.isEmpty()) {
			
			System.out.println("List is empty");
			return;
			
		} else if(id <= 0) {
			
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
					return;
					
				}
				
			}
			if(i < nightClubs.size()) {
				
				if(nightClubs.get(i).getId() == id) {
					
					nightClubs.remove(i);
					return;
					
				}
				
			}
			if(i < restaurants.size()) {
				
				if(restaurants.get(i).getId() == id) {
					
					restaurants.remove(i);
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
