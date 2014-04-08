package org.hillel.it.mycity.persistence.repository;

import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.User;

public interface UserRepository {
	public void addRegistratedUser(User registratedUser);
	public void addModerator(Moderator	moderator);
	public void addAdministrator(Administrator administrator);
	public void deleteUserById(int id);
	public <T> T getUserById(int id, Class<T> type);
	public List<Administrator> getAllAdministrators();
	public List<Moderator> getAllModerators();
	public List<User> getAllRegistratedUsers();
	public int getLastId();
}
