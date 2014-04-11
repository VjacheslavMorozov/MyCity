package org.hillel.it.mycity.model.entity;

import java.util.HashSet;
import java.util.Set;

public abstract class Person extends BaseEntity{
	private String firstName;
	private String lastName;
	private String username;
	private String eMail;
	private String password;
	private Set<String> usernameSet = new HashSet<>();
	private Set<String> emailSet = new HashSet<>();
	private Group group;
	
	public boolean inGroup(Group group){
		return group == this.group;
	}

	public void loginTest(String login) {
		int size = usernameSet.size();
		usernameSet.add(this.username);
		if(size == usernameSet.size()) {
			throw new RuntimeException("Login is ready used");
		}
	}
	
	public void emailTest(String eMail) {
		int size = emailSet.size();
		emailSet.add(this.username);
		if(size == emailSet.size()) {
			throw new RuntimeException("eMail is ready used");
		}
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
		try {
			loginTest(username);
		} catch (RuntimeException e) {
			System.out.println("Try another login" + e);
		}
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
		try {
			emailTest(eMail);
		} catch (RuntimeException e) {
			System.out.println("Try another email" + e);
		}
		this.eMail = eMail;
	}
	
	public String getEMail() {
		return eMail;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
}
