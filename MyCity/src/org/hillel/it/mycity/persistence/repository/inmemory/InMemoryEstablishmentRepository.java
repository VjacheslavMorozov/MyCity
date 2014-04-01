package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	@Override
	public Cinema getEstablishmentCinemaById(int id) {
		
		if(id == 0){
			
			System.out.println("Incorrect id");
			return null;
			
		}
		for(Cinema cinema: cinemas){
			if(cinema.getId() == id){
				
				return cinema;
				
			}
		}
		return null;
		
	}

	@Override
	public NightClub getEstablishmentNightClubById(int id) {
	
		if(id == 0){
			
			System.out.println("Incorrect id");
			return null;
			
		}
		for(NightClub nightClub: nightClubs){
			if(nightClub.getId() == id){
				
				return nightClub;
				
			}
		}
		return null;
		
	}

	@Override
	public Restaurant getEstablishmentRestaurantById(int id) {
		
		if(id == 0){
			
			System.out.println("Incorrect id");
			return null;
			
		}
		for(Restaurant restaurant: restaurants){
			if(restaurant.getId() == id){
				
				return restaurant;
				
			}
		}
		return null;
		
	}

	@Override
	public List<Cinema> getAllCinemaEstablishment() {
		
		if(cinemas.isEmpty()){
			System.out.println("List of Cinemas is epmty");
			return null;
		}
		return cinemas;
		
	}

	@Override
	public List<NightClub> getAllNightClubEstablishment() {
		
		if(nightClubs.isEmpty()){
			System.out.println("List of Night Clubs is epmty");
			return null;
		}
		return nightClubs;
		
	}

	@Override
	public List<Restaurant> getAllRestaurantEstablishment() {
		
		if(restaurants.isEmpty()){
			System.out.println("List of Restaurants is epmty");
			return null;
		}
		return restaurants;
		
	}

	@Override
	public void deleteAllCinemaEstablishments() {
		
		cinemas.clear();
		
	}

	@Override
	public void deleteAllNightClubEstablishments() {
		
		nightClubs.clear();
		
	}

	@Override
	public void deleteAllRestaurantEstablishments() {
		
		restaurants.clear();
		
	}

	@Override
	public void deleteEstablishmentById(int id) {
		
		int index = 0;
		if(cinemas.isEmpty() && nightClubs.isEmpty() && restaurants.isEmpty()) {
			
			System.out.println("List is empty");
			return;
			
		} else if(id == 0) {
			
			System.out.println("Incorrect id");
			
		}
		for(Cinema cinema: cinemas){
			if(cinema.getId() == id){
				
				cinemas.remove(index);
				return;
				
			}	
			index++;
			
		}
		
		index = 0;
		
		for(NightClub nightClub: nightClubs){
			if(nightClub.getId() == id){
				
				nightClubs.remove(index);
				return;
				
			}	
			index++;
		}
		
		index = 0;
		
		for(Restaurant restaurant: restaurants){
			if(restaurant.getId() == id){
				
				restaurants.remove(index);
				return;
				
			}	
			index++;
			
		}
	}

	@Override
	public void deleteAllEstablishments() {
		
		deleteAllCinemaEstablishments();
		deleteAllNightClubEstablishments();
		deleteAllRestaurantEstablishments();
		
	}
	
}
