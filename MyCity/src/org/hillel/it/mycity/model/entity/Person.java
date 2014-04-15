package org.hillel.it.mycity.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hillel.it.mycity.helper.CryptoHelper;

public abstract class Person extends BaseEntity{
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String eMail;
	protected String password;
	protected Group group;
	
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
	
	public void setLogin(String username) {
		this.username = username;
	}
	
	public String getLogin() {
		return username;
	}
	
	/**
	 * Method that allows a person to log in. 
	 * @param username
	 * @param password
	 * @return Object of Person type
	 */
	public static Person logIn(String username, String password){
		// Смотрит есть ли пользователь с такими именем пользователя и паролем в БД. 
		// В случае успешного входа создаем объект на этого пользователя.
		// Предлагаю вынести этот метод в класс InMemoryUserRepository
		return PersonFactory.getPerson(Group.Administrator);
	}
	
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getEMail() {
		return eMail;
	}
	
	public void setPassword(String password) {
		this.password = CryptoHelper.shaOne(password);
	}
	
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
	
}
