package org.hillel.it.mycity.persistence.repository;

public interface UserRepository {
	public void addRegistratedUser();
	public void addModerator();
	public void addAdministrator();
	public boolean deleteUserById();
}
