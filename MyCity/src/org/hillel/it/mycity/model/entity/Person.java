package org.hillel.it.mycity.model.entity;

import java.util.HashSet;
import java.util.Set;

public abstract class Person extends BaseEntity{
	private String firstName;
	private String lastName;
	private String login;
	private String eMail;
	private String password;
	private Set<String> loginSet = new HashSet<>();
	private Set<String> emailSet = new HashSet<>();
	
	public Person(Administrator administrator) {
		super(administrator);
	}

	public void loginTest(String login) {
		int size = loginSet.size();
		loginSet.add(this.login);
		if(size == loginSet.size()) {
			throw new RuntimeException("Login is ready used");
		}
	}
	
	public void emailTest(String eMail) {
		int size = emailSet.size();
		emailSet.add(this.login);
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
	
	public void setLogin(String login) {
		try {
			loginTest(login);
		} catch (RuntimeException e) {
			System.out.println("Try another login" + e);
		}
		this.login = login;
	}
	
	public String getLogin() {
		return login;
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
}
