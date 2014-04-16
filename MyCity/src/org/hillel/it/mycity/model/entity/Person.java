package org.hillel.it.mycity.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.hillel.it.mycity.helper.CryptoHelper;

public abstract class Person extends BaseEntity{
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private Group group;
	private boolean emailVerified; //прошел ли email проверку на подлинность
	
	public Person(String email, String password) {
		setEmail(email);
		setPassword(password);
		emailVerified = false;
	}
	
	/**
	 * Method that return group of class Person (Administrator, Moderator, User)
	 * @param group It is eNum of groups
	 * @return true if group of the person equals to group in argument otherwise return false  
	 */
	public boolean inGroup(Group group){
		return group == this.group;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setUsername(String username) {
		if(!checkUserName(username)) {
			return;
		}
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	/**
	 * Method that allows a person to log in. 
	 * @param username
	 * @param password
	 * @return Object of Person type
	 * @deprecated
	 */
	public static Person logIn(String username, String password){
		// Смотрит есть ли пользователь с такими именем пользователя и паролем в БД. 
		// В случае успешного входа создаем объект на этого пользователя.
		// Предлагаю вынести этот метод в класс InMemoryUserRepository
		return PersonFactory.getPerson(Group.Administrator);
	}
	
	/**
	 * Set email of this object, from email in argument if it pass the validation
	 * (Apache Commons Validator - EmailValidator)
	 * @param email 
	 */
	public void setEmail(String email) {
		if(!EmailValidator.getInstance().isValid(email)) {
			System.out.println("This email is invalid");
			return;
		}
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = CryptoHelper.shaOne(password);
	}
	
	//может сделать проверку на получение password?
	//то есть его может получить только Administrator или его User
	public String getPassword() {
		return password;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	
	/**
	 * This method create Comment.
	 * @param userComment String type comment that received from user
	 * @return null if User that create comment is do not exist in Repository or return Comment.
	 */
	public Comment addComment(String userComment) {
		try {
			checkId(getId());
		} catch (RuntimeException e) {
			System.out.println("This user is does not exist");
		}
		Comment comment = new Comment();
		comment.setCreatedBy(this);
		comment.setComment(userComment);
		return comment;
	}
	
	/**
	 * 
	 * @param comment
	 * @param userComment
	 * @return
	 */
	public void changeComment(Comment comment, String userComment) {
		if(comment.getCreatedBy() != this && !inGroup(Group.Administrator)) {
			System.out.println("This user cannot change this comment");
			return;
		}
		comment.setComment(userComment);
		comment.setModifiedBy(this);
		comment.setModifiedDate(new Date());
	}
	
	public Assessment addAssessment(int userAssessment) {
		try {
			checkId(getId());
		} catch (RuntimeException e) {
			System.out.println("This user is does not exist");
		}
		Assessment assessment = new Assessment();
		assessment.setCreatedBy(this);
		assessment.setAssessment(userAssessment);
		return assessment;
	}
	
	public void changeAssessment(Assessment assessment, int userAssessment) {
		if(assessment.getCreatedBy() != this) {
			System.out.println("This user can not change this comment");
			return;
		}
		assessment.setAssessment(userAssessment);
		assessment.setModifiedBy(this);
		assessment.setModifiedDate(new Date());
	}
	
	/**
	 * Method <code>checkUserName</code> return true if <code>userName</code> is pass all checks. False if
	 * <code>userName</code> length less than 4 symbols or <code>userName</code> is Empty (== null)
	 * or if <code>userName</code> starts with space symbol.
	 * @param userName
	 * @return
	 */
	private boolean checkUserName(String username) {
		if(username.length() <= 3 || username.isEmpty()) {
			System.out.println("Username cat not be less than 3 symbols");
			return false;
		}
		Pattern pattern = Pattern.compile("^\\S\\w");
		Matcher matcher = pattern.matcher(username);
		if(!matcher.find()) {
			System.out.println("Username can not contains space symbol as a first character.");
			return false;
		}
		return true;
		
	}
	
	public void setEmailVarified() {
		emailVerified = true;
	}
	
}
