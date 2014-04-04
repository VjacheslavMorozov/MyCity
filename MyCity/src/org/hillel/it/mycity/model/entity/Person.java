package org.hillel.it.mycity.model.entity;

public abstract class Person extends BaseEntity{
	private String firstName;
	private String lastName;
	private String login;
	private String eMail;
	private String password;
	
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
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setEMail(String eMail) {
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
