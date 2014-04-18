package org.hillel.it.mycity.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

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
import org.w3c.dom.ranges.RangeException;

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
	public void addRestaurant(Restaurant restaurant) {
		try {
			checkUser(restaurant);
			establishmentRepository.addRestaurant(restaurant);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		
	}

	@Override
	public void addNightClub(NightClub nightClub) {
		try {
			checkUser(nightClub);
			establishmentRepository.addNightClub(nightClub);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		
	}

	@Override
	public void addCinema(Cinema cinema) {
		try {
			checkUser(cinema);
			establishmentRepository.addCinema(cinema);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}
	
	// DELETE Establishment

	@Override
	public void deleteEstablishments() {
		establishmentRepository.deleteEstablishments();
	}

	@Override
	public void deleteEstablishment(int id) {
		try {
			establishmentRepository.deleteEstablishment(id);
		} catch (NullPointerException e) {
			System.out.println(e);
			throw new NullPointerException();
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	// READ Establishment
	@Override
	public List<Cinema> getCinemas(){
		return establishmentRepository.getCinemas();
	}
	
	@Override
	public List<NightClub> getNightClubs() {
		return establishmentRepository.getNightClubs();
	}
	
	@Override
	public List<Restaurant> getRestaurants() {
		return establishmentRepository.getRestaurants();
	}
	
	@Override
	public Cinema getCinema(int id) {
		try {
			return establishmentRepository.getCinema(id);
		} catch (NullPointerException e) {
			throw new NullPointerException("Incorrect id");
		}
	}

	@Override
	public NightClub getNightClub(int id) {
		try {
			return establishmentRepository.getNightClub(id);
		} catch (NullPointerException e) {
			throw new NullPointerException("Incorrect id");
		}
	}

	@Override
	public Restaurant getRestaurant(int id) {
		try {
			return establishmentRepository.getRestaurant(id);
		} catch (NullPointerException e) {
			throw new NullPointerException("Incorrect id");
		}
	}
	
	// CREATE Person
	@Override
	public void addAdministrator(Administrator administrator) {
		try {
			userRepository.addAdministrator(administrator);
		} catch (RuntimeException e) {
			throw new RuntimeException("This user is already exist");
		}
	}

	@Override
	public void addModerator(Moderator moderator) {
		try {
			userRepository.addModerator(moderator);
		} catch (RuntimeException e) {
			throw new RuntimeException("This user is already exist");
		}
		
	}

	@Override
	public void addUser(User user) {
		try {
			userRepository.addUser(user);
		} catch (RuntimeException e) {
			throw new RuntimeException("This user is already exist");
		}
		
	}
	
	//READ Person
	@Override
	public List<Administrator> getAdministrators() {
		return userRepository.getAdministrators();
	}

	@Override
	public List<Moderator> getModerators() {
		return userRepository.getModerators();
	}

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}
	
	@Override
	public Administrator getAdministrator(int id) {
		try {
			return userRepository.getAdministrator(id);
		} catch (NullPointerException e) {
			throw new NullPointerException("List of users is empty");
		}
	}

	@Override
	public Moderator getModerator(int id) {
		try {
			return userRepository.getModerator(id);
		} catch (NullPointerException e) {
			throw new NullPointerException("List of users is empty");
		}
	}

	@Override
	public User getUser(int id) {
		try {
			return userRepository.getUser(id);
		} catch (NullPointerException e) {
			throw new NullPointerException("List of users is empty");
		}
	}

	//DELETE Person
	@Override
	public void deleteUsers() {
		userRepository.deleteUsers();
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteUser(id);
	}

	//CREATE Comment
	@Override
	public void addComment(Comment comment) {
		try {
			checkUser(comment);
			commentRepository.addComment(comment);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	//DELETE Comment
	@Override
	public void deleteComment(int id) {
		try {
			checkUser(getComment(id));
			commentRepository.deleteComment(id);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteComments(Person user) {
		try {
			checkUser(loggedUser);
			commentRepository.deleteComments(user);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		
	}

	@Override
	public void deleteComments(Establishment establishment) {
		try {
			checkUser(loggedUser);
			commentRepository.deleteComments(establishment);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteComments(Establishment establishment, Person user) {
		try {
			checkUser(loggedUser);
			commentRepository.deleteComments(establishment,user);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		
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
		try {
			checkUser(assessment);
			assessmentRepository.addAssessment(assessment);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	//DELETE Assessment
	@Override
	public void deleteAssessment(int id) {
		try {
			checkUser(loggedUser);
			assessmentRepository.deleteAssessment(id);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteAssessment(Person user) {
		try {
			checkUser(loggedUser);
			assessmentRepository.deleteAssessment(user);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteAssessment(Establishment establishment) {
		try {
			checkUser(loggedUser);
			assessmentRepository.deleteAssessment(establishment);
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		
	}

	//READ Assessment
	@Override
	public Assessment getAssessment(int id) {
		try {
			checkUser(loggedUser);
			return assessmentRepository.getAssessment(id);
		} catch (NullPointerException e){
			System.out.println(e);
			throw new NullPointerException();
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	@Override
	public List<Assessment> getAssessments(Person user) {
		try {
			checkUser(loggedUser);
			return assessmentRepository.getAssessments(user);
		} catch (NullPointerException e){
			System.out.println(e);
			throw new NullPointerException();
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	@Override
	public List<Assessment> getAssessments(Establishment establishment) {
		try {
			checkUser(loggedUser);
			return assessmentRepository.getAssessments(establishment);
		} catch (NullPointerException e){
			System.out.println(e);
			throw new NullPointerException();
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	@Override
	public List<Assessment> getAssessments() {
		return assessmentRepository.getAssessments();
	}
	
	public void setLoggedUser(Person user) {
		loggedUser = user;
	}
	
	private <T extends BaseEntity>void checkUser(T t) {
		if(loggedUser.inGroup(Group.Administrator) == false && !(t.getClass() == Assessment.class) && !(t.getClass() == Comment.class)) {
			throw new RuntimeException("Administrator has no login");
		} else if(t.getCreatedBy().getId() == 0 || !loggedUser.equals(t.getCreatedBy())) {
			throw new RuntimeException("This user cannot create/delete object");
		} else if(loggedUser == null) {
			throw new RuntimeException("Users has no login into the system. Call setLoggedUser method");
		}
	}
}
