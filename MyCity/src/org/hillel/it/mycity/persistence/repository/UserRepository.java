package org.hillel.it.mycity.persistence.repository;

import java.io.IOException;
import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.User;

public interface UserRepository {
	
	public void addUser(User user);
	public void addModerator(Moderator	moderator);
	public void addAdministrator(Administrator administrator);
	public void deleteUser(int id);
	public User getUser(int id);
	public Moderator getModerator(int id);
	public Administrator getAdministrator(int id);
	public List<Administrator> getAdministrators();
	public List<Moderator> getModerators();
	public List<User> getUsers();
	public void deleteUsers();
}
