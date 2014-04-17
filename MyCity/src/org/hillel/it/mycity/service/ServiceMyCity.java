package org.hillel.it.mycity.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Assessment;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.model.entity.User;

public interface ServiceMyCity {
	//Establishment repository
	// CREATE Establishment
	/* @timur Тут можно попробовать реализовать шаблон FactoryMethod.
	 * Тогда будет всего один метод типа
	 * public void addEstablishment(EstType estType), 
	 * где EstType - перечисление Restaurant, NightClub, Cinema.
	 * 
	 * Параметр Administrator administrator надо убирать и менять реализацию.
	 * В системе будет существовать объект типа Person person, который будет содержать инфу
	 * о залогинившемся пользователе. Реализация метода addEstablishmentRestaurant
	 * будет обращаться к методу person.inGroup("admin"). 
	 * 
	 */ 
	public void addEstablishmentRestaurant(Restaurant restaurant);
	public void addEstablishmentNightClub(NightClub nightClub);
	public void addEstablishmentCinema(Cinema cinema);
	
	// READ Establishment
	public List<Cinema> getAllCinemaEstablishment();
	public List<NightClub> getAllNightClubEstablishment();
	public List<Restaurant> getAllRestaurantEstablishment();
	
	public Cinema getCinemaEstablishmentById(int id);
	public NightClub getNightClubEstablishmentById(int id);
	public Restaurant getRestaurantEstablishmentById(int id);

	// UPDATE Establishment
	// @timur need to add update Establishment methods

	// DELETE Establishment
	public void deleteAllEstablishments();
	public void deleteEstablishmentById(int id);
	public void deleteEstablishmentByType(String establishmentType);
	
	// Person repository
	// CREATE Person
	public void addAdministrator(Administrator administrator);
	public void addModerator(Moderator moderator);
	public void addUser(User user);

	// READ Person
	public List<Administrator> getAllAdministrators();
	public List<Moderator> getAllModerators();
	public List<User> getAllUsers();

	public Administrator getAdministratorById(int id);
	public Moderator getModeratorById(int id);
	public User getUserById(int id);

	// UPDATE Person
	// @timur need to add update Person methods
	// @Artem а зачем, если можно вызвать метод get<Person> и уже у этого Объекта изменить данные.

	// DELETE Person
	public void deleteAllUsers();
	public void deleteUserById(int id);
	
	//CommentRepository
	//CREATE Comment
	public void addComment(Comment comment);
	
	//DELETE Comment
	public void deleteComment(int id);
	public void deleteComments(Person user);
	public void deleteComments(Establishment establishment);
	public void deleteComments(Establishment establishment, Person user);

	//READ Comment
	public Comment getComment(int id);
	public List<Comment> getComments(Person user);
	public List<Comment> getComments(Establishment establishment);
	public List<Comment> getComments(Establishment establishment, Person user);
	public List<Comment> getComments();

	//AssessmentRepository
	//CREATE Assessment
	public void addAssessment(Assessment assessment);
	
	//DELETE Assessment
	public void deleteAssessment(int id);
	public void deleteAssessment(Person user);
	public void deleteAssessment(Establishment establishment);
	
	//READ Assessment
	public Assessment getAssessment(int id);
	public List<Assessment> getAssessments(Person user);
	public List<Assessment> getAssessments(Establishment establishment);
	public List<Assessment> getAssessments();
}
