package org.hillel.it.mycity.service.impl;

import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.service.ServiceMyCity;

public class ServiceImpl implements ServiceMyCity {
	private EstablishmentRepository establishmentRepository;
	
	public ServiceImpl(EstablishmentRepository establishmentRepository) {
		this.establishmentRepository = establishmentRepository;
	}
	
	@Override
	public void addEstablishmentRestaurant(Administrator administrator) {
		if(administrator.getLogin() == null) {
			System.out.println("Administrator has no login");
			return;
		}
		Restaurant restaurant = new Restaurant(administrator);
		establishmentRepository.addEstablishmentRestaurant(restaurant);
	}

	@Override
	public void addEstablishmentNightClub(Administrator administrator) {
		if(administrator.getLogin() == null) {
			System.out.println("Administrator has no login");
			return;
		}
		NightClub nightClub = new NightClub(administrator);
		establishmentRepository.addEstablishmentNightClub(nightClub);
	}

	@Override
	public void addEstablishmentCinema(Administrator administrator) {
		if(administrator.getLogin() == null) {
			System.out.println("Administrator has no login");
			return;
		}
		Cinema cinema = new Cinema(administrator);
		establishmentRepository.addEstablishmentCinema(cinema);
	}
	
	public void deleteEstablishmentByType(String establishmentType) {
		establishmentRepository.deleteEstablishmentByType(establishmentType);
	}
	
	@Override
	public List<Cinema> getAllCinemaEstablishment(){
		if(establishmentRepository.getAllCinemaEstablishment() == null) {
			System.out.println("List of Cinema Establishments is empty");
			return null;
		}
		return establishmentRepository.getAllCinemaEstablishment();
	}
	
	@Override
	public List<NightClub> getAllNightClubEstablishment() {
		if(establishmentRepository.getAllNightClubEstablishment() == null) {
			System.out.println("List of Night Club Establishments is empty");
			return null;
		}
		return establishmentRepository.getAllNightClubEstablishment();
	}
	
	@Override
	public List<Restaurant> getAllRestaurantEstablishment() {
		if(establishmentRepository.getAllRestaurantEstablishment() == null) {
			System.out.println("List of Restaurant Establishments is empty");
			return null;
		}
		return establishmentRepository.getAllRestaurantEstablishment();
	}

	@Override
	public void deleteAllEstablishments() {
		establishmentRepository.deleteAllEstablishments();
	}

	@Override
	public void deleteEstablishmentById(int id) {
		establishmentRepository.deleteEstablishmentById(id);
	}

	@Override
	public Cinema getCinemaEstablishmentById(int id) {
		return establishmentRepository.getEstablishmentById(id, Cinema.class);
	}

	@Override
	public NightClub getNightClubEstablishmentById(int id) {
		return establishmentRepository.getEstablishmentById(id, NightClub.class);
	}

	@Override
	public Restaurant getRestaurantEstablishmentById(int id) {
		return establishmentRepository.getEstablishmentById(id, Restaurant.class);
	}
	
	public int getLastId() {
		return establishmentRepository.getLastId();
	}

	@Override
	public void addAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addModerator(Administrator administrator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(Administrator administrator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Administrator> getAllAdministrators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Moderator> getAllModerators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrator getAdministratorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Moderator getModeratorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
