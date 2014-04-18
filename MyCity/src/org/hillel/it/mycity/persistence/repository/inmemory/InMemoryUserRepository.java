package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.UserRepository;

public class InMemoryUserRepository implements UserRepository{
	
	private List<Administrator> administrators;
	private List<Moderator> moderators;
	private List<User> users;
	private int maxId;
	
	public InMemoryUserRepository() {
		administrators = new ArrayList<>();
		moderators = new ArrayList<>();
		users = new ArrayList<>();
		maxId = 1;
	}

	@Override
	public void addUser(User user) {
		try {
			validUser(user);
			user.setGroup(Group.User);
			user.setId(maxId);
			users.add(user);
			maxId++;
		} catch (RuntimeException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void addModerator(Moderator moderator) {
		try {
			validUser(moderator);
			moderator.setGroup(Group.Moderator);
			moderator.setId(maxId);
			moderators.add(moderator);
			maxId++;
		} catch (RuntimeException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	@Override
	public void addAdministrator(Administrator administrator) {
		try {
			validUser(administrator);
			administrator.setGroup(Group.Administrator);
			administrator.setId(maxId);
			administrators.add(administrator);
			maxId++;
		} catch (RuntimeException e) {
			throw new RuntimeException();
		}
	}
	
	public <T extends Person>void validUser(T t) {
		if(t.getId() > 0) {
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteUser(int id) {
		if(id < 1 || id > maxId) {
			System.out.println("Incorrect Id");
			return;
		}
		if(administrators.isEmpty() && moderators.isEmpty() && users.isEmpty()) {
			System.out.println("All user arrays is empty");
			return;
		}
		if(!administrators.isEmpty()) {
			Iterator<Administrator> iterator = administrators.iterator();
			while(iterator.hasNext()) {
				if(iterator.next().getId() == id) {
					iterator.remove();
					return;
				}
			}
		} else if(!moderators.isEmpty()) {
			Iterator<Moderator> iterator = moderators.iterator();
			while (iterator.hasNext()) {
				if(iterator.next().getId() == id) {
					iterator.remove();
					return;
				}
			}
		} else if(!users.isEmpty()) {
			Iterator<User> iterator = users.iterator();
			while (iterator.hasNext()) {
				if(iterator.next().getId() == id) {
					iterator.remove();
					return;
				}
			}
		}
	}

	@Override
	public List<Administrator> getAdministrators() {
		List<Administrator> administrators = this.administrators; 
		return administrators;
	}

	@Override
	public List<Moderator> getModerators() {
		List<Moderator> moderators = this.moderators;
		return moderators;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = this.users;
		return users;
	}

	@Override
	public void deleteUsers() {
		administrators.clear();
		moderators.clear();
		users.clear();
	}

	@Override
	public User getUser(int id) {
		try {
			Objects.requireNonNull(users);
			for(User user : users) {
				if (user.getId() == id) {
					return user;
				}
			}
		} catch (NullPointerException e) {
			throw new NullPointerException();
		}
		return null;
	}

	@Override
	public Moderator getModerator(int id) {
		try {
			Objects.requireNonNull(moderators);
			for(Moderator moderator : moderators) {
				if (moderator.getId() == id) {
					return moderator;
				}
			}
		} catch (NullPointerException e) {
			throw new NullPointerException();
		}
		return null;
	}

	@Override
	public Administrator getAdministrator(int id) {
		try {
			Objects.requireNonNull(administrators);
			for(Administrator administrator : administrators) {
				if (administrator.getId() == id) {
					return administrator;
				}
			}
		} catch (NullPointerException e) {
			throw new NullPointerException();
		}
		return null;
	}

}
