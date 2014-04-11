package org.hillel.it.mycity.service.impl;

import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.service.ServiceMyCity;

public class ServiceImpl implements ServiceMyCity {
	private EstablishmentRepository establishmentRepository;
	private UserRepository userRepository;
	private Person loggedPerson; 
	
	public ServiceImpl(EstablishmentRepository establishmentRepository, UserRepository userRepository,Person loggedPerson) {
		this.establishmentRepository = establishmentRepository;
		this.userRepository = userRepository;
		this.loggedPerson = loggedPerson;
	}
	
	// CREATE Establishment
	@Override
	public void addEstablishmentRestaurant(Restaurant restaurant) {
		if( this.loggedPerson.inGroup(Group.Administrator) == false ) {
			System.out.println("Administrator has no login");
			return;
		}
		establishmentRepository.addEstablishmentRestaurant(restaurant);
	}

	@Override
	public void addEstablishmentNightClub(NightClub nightClub) {
		establishmentRepository.addEstablishmentNightClub(nightClub);
	}

	@Override
	public void addEstablishmentCinema(Cinema cinema) {
		establishmentRepository.addEstablishmentCinema(cinema);
	}
	
	// DELETE Establishment
	public void deleteEstablishmentByType(String establishmentType) {
		establishmentRepository.deleteEstablishmentByType(establishmentType);
	}

	@Override
	public void deleteAllEstablishments() {
		establishmentRepository.deleteAllEstablishments();
	}

	@Override
	public void deleteEstablishmentById(int id) {
		establishmentRepository.deleteEstablishmentById(id);
	}

	// READ Establishment
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

	@Override
	public void addAdministrator(Administrator administrator) {
		userRepository.addAdministrator(administrator);
	}

	@Override
	public void addModerator(Moderator moderator) {
		userRepository.addModerator(moderator);
	}

	@Override
	public void addUser(User user) {
		userRepository.addRegistratedUser(user);
	}

	@Override
	public List<Administrator> getAllAdministrators() {
		return userRepository.getAllAdministrators();
	}

	@Override
	public List<Moderator> getAllModerators() {
		return userRepository.getAllModerators();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAllUsers();
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteUserById(id);
	}

	@Override
	public Administrator getAdministratorById(int id) {
		return userRepository.getUserById(id, Administrator.class);
	}

	@Override
	public Moderator getModeratorById(int id) {
		return userRepository.getUserById(id, Moderator.class);
	}

	@Override
	public User getUserById(int id) {
		return userRepository.getUserById(id, User.class);
	}
}
