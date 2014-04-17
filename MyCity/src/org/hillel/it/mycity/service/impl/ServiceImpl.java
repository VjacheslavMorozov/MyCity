package org.hillel.it.mycity.service.impl;

import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Assessment;
import org.hillel.it.mycity.model.entity.BaseEntity;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.AssessmentRepository;
import org.hillel.it.mycity.persistence.repository.CommentRepository;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.service.ServiceMyCity;

public class ServiceImpl implements ServiceMyCity {
	private EstablishmentRepository establishmentRepository;
	private UserRepository userRepository;
	private CommentRepository commentRepository;
	private AssessmentRepository assessmentRepository;
	private Person loggedUser; 
	
	public ServiceImpl(EstablishmentRepository establishmentRepository, UserRepository userRepository, CommentRepository commentRepository, AssessmentRepository assessmentRepository) {
		this.establishmentRepository = establishmentRepository;
		this.userRepository = userRepository;
		this.commentRepository = commentRepository;
		this.assessmentRepository = assessmentRepository;
	}
	
	// CREATE Establishment
	@Override
	public void addEstablishmentRestaurant(Restaurant restaurant) {
		if(!checkUser(restaurant)) {
			return;
		}
		establishmentRepository.addEstablishmentRestaurant(restaurant);
	}

	@Override
	public void addEstablishmentNightClub(NightClub nightClub) {
		if(!checkUser(nightClub)) {
			return;
		}
		establishmentRepository.addEstablishmentNightClub(nightClub);
	}

	@Override
	public void addEstablishmentCinema(Cinema cinema) {
		if(!checkUser(cinema)) {
			return;
		}
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
	
	// CREATE Person
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
	
	//READ Person
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

	//DELETE Person
	@Override
	public void deleteAllUsers() {
		userRepository.deleteAllUsers();
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteUserById(id);
	}
	
	public void setLoggedUser(Person user) {
		loggedUser = user;
	}
	
	private <T>boolean checkUser(T t) {
		if(this.loggedUser.inGroup(Group.Administrator) == false ) {
			System.out.println("Administrator has no login");
			return false;
		}
		else if(((BaseEntity) t).getCreatedBy().getId() == 0) {
			System.out.println("This user cannot create object");
			return false;
		}
		else if(loggedUser == null) {
			System.out.println("Users has no login into the system. Call setLoggedUser method");
			return false;
		}
		return true;
	}

	//CREATE Comment
	@Override
	public void addComment(Comment comment) {
		if (!checkUser(comment)) {
			return;
		}
		commentRepository.addComment(comment);
	}

	//DELETE Comment
	@Override
	public void deleteComment(int id) {
		if(!loggedUser.inGroup(Group.Administrator) && !loggedUser.getCreatedBy().equals(getComment(id))) {
			System.out.println("You can not delete this comment");
			return;
		}
		commentRepository.deleteComment(id);
	}

	@Override
	public void deleteComments(Person user) {
		if(!loggedUser.inGroup(Group.Administrator)) {
			System.out.println("This user has no rights to delete this");
			return;
		}
		commentRepository.deleteComments(user);
	}

	@Override
	public void deleteComments(Establishment establishment) {
		if(!loggedUser.inGroup(Group.Administrator)) {
			System.out.println("This user has no rights to delete this");
			return;
		}
		commentRepository.deleteComments(establishment);
	}

	@Override
	public void deleteComments(Establishment establishment, Person user) {
		if(!loggedUser.inGroup(Group.Administrator)) {
			System.out.println("This user has no rights to delete this");
			return;
		}
		commentRepository.deleteComments(establishment,user);
	}

	//READ Comment
	@Override
	public Comment getComment(int id) {
		return commentRepository.getComment(id);
	}

	@Override
	public List<Comment> getComments(Person user) {
		return commentRepository.getComments(user);
	}

	@Override
	public List<Comment> getComments(Establishment establishment) {
		return commentRepository.getComments(establishment);
	}

	@Override
	public List<Comment> getComments(Establishment establishment, Person user) {
		return commentRepository.getComments(establishment, user);
	}

	@Override
	public List<Comment> getComments() {
		return commentRepository.getComments();
	}

	//CREATE Assessment
	@Override
	public void addAssessment(Assessment assessment) {
		if (!checkUser(assessment)) {
			return;
		}
		assessmentRepository.addAssessment(assessment);
	}

	//DELETE Assessment
	@Override
	public void deleteAssessment(int id) {
		if(!loggedUser.getCreatedBy().equals(assessmentRepository.getAssessment(id))) {
			System.out.println("This user can not delete this object");
			return;
		}
		assessmentRepository.deleteAssessment(id);
	}

	@Override
	public void deleteAssessment(Person user) {
		if(!loggedUser.inGroup(Group.Administrator)) {
			System.out.println("This user has no rights to delete this");
			return;
		}
		assessmentRepository.deleteAssessment(user);
	}

	@Override
	public void deleteAssessment(Establishment establishment) {
		if(!loggedUser.inGroup(Group.Administrator)) {
			System.out.println("This user has no rights to delete this");
			return;
		}
		assessmentRepository.deleteAssessment(establishment);
	}

	//READ Assessment
	@Override
	public Assessment getAssessment(int id) {
		return assessmentRepository.getAssessment(id);
	}

	@Override
	public List<Assessment> getAssessments(Person user) {
		return assessmentRepository.getAssessments(user);
	}

	@Override
	public List<Assessment> getAssessments(Establishment establishment) {
		return assessmentRepository.getAssessments(establishment);
	}

	@Override
	public List<Assessment> getAssessments() {
		return assessmentRepository.getAssessments();
	}
}
