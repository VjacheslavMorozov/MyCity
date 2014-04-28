package org.hillel.it.mycity.persistence.repository.inmemory;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.UserRepository;

public class InMemoryUserRepository implements UserRepository, Serializable{
	
	private static final long serialVersionUID = 2L;
	protected List<Administrator> administrators;
	protected List<Moderator> moderators;
	protected List<User> users;
	protected Map<Integer, Group> userMap;
	protected int maxId;
	private FileUserRepository fileUserRepository;
	
	public InMemoryUserRepository() {
		administrators = new ArrayList<>();
		moderators = new ArrayList<>();
		users = new ArrayList<>();
		userMap = new HashMap<Integer, Group>();
		maxId = 1;
	}

	@Override
	public void addUser(User user) {
		validUser(user);
		user.setGroup(Group.User);
		userMap.put(maxId, Group.User);
		user.setId(maxId++);
		users.add(user);
		fileUserRepository.sereializeUserData(users, Group.User);
	}

	@Override
	public void addModerator(Moderator moderator) {
		validUser(moderator);
		moderator.setGroup(Group.Moderator);
		userMap.put(maxId, Group.Moderator);
		moderator.setId(maxId++);
		moderators.add(moderator);
		fileUserRepository.sereializeUserData(moderators, Group.Moderator);
	}

	@Override
	public void addAdministrator(Administrator administrator) {
		validUser(administrator);
		administrator.setGroup(Group.Administrator);
		userMap.put(maxId, Group.Administrator);
		administrator.setId(maxId++);
		administrators.add(administrator);
		fileUserRepository.sereializeUserData(administrators, Group.Administrator);
	}

	@Override
	public void deleteUser(int id) {
		validId(id);
		
		switch (userMap.get(id)) {
		case User:
			Iterator<User> iteratorUsers = users.iterator();
			while(iteratorUsers.hasNext()) {
				if(iteratorUsers.next().getId() == id) {
					iteratorUsers.remove();
					return;
				}
			}
			break;
		case Moderator:
			Iterator<Moderator> iteratorModerators = moderators.iterator();
			while (iteratorModerators.hasNext()) {
				if(iteratorModerators.next().getId() == id) {
					iteratorModerators.remove();
					return;
				}
			}
			break;
		case Administrator:
			Iterator<Administrator> iteratorAdministrators = administrators.iterator();
			while (iteratorAdministrators.hasNext()) {
				if(iteratorAdministrators.next().getId() == id) {
					iteratorAdministrators.remove();
					return;
				}
			}
			break;
		}
	}

	@Override
	public List<Administrator> getAdministrators() {
		return Collections.unmodifiableList(administrators);
	}

	@Override
	public List<Moderator> getModerators() {
		return Collections.unmodifiableList(moderators);
	}

	@Override
	public List<User> getUsers() {
		return Collections.unmodifiableList(users);
	}

	@Override
	public void deleteUsers() {
		administrators.clear();
		moderators.clear();
		users.clear();
	}

	@Override
	public User getUser(int id) {
		if(!checkGroup(id, Group.User)) {
			return null;
		}
		for(User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public Moderator getModerator(int id) {
		if(!checkGroup(id, Group.Moderator)) {
			return null;
		}
		for(Moderator moderator : moderators) {
			if (moderator.getId() == id) {
				return moderator;
			}
		}
		return null;
	}

	@Override
	public Administrator getAdministrator(int id) {
		if(!checkGroup(id, Group.Administrator)) {
			return null;
		}
		for(Administrator administrator : administrators) {
			if (administrator.getId() == id) {
				return administrator;
			}
		}
		return null;
	}
	
	public void setAdministratorsDeserialization(List<Administrator> administrators) {
		this.administrators = administrators;
	}
	
	public List<Administrator> getAdministratorsForSerialization() {
		return administrators;
	}
	
	public int getMaxId() {
		return maxId;
	}
	
	private <T extends Person>void validUser(T t) {
		if(t.getId() < 1 && userMap.containsKey(t.getId())) {
			throw new RuntimeException("User is already exist or he have incorrect id");
		}
	}
	
	private void validId(int id) {
		if(id < 1 && !userMap.containsKey(id)) {
			throw new RuntimeException("Incorrect Id");
		}
	}
	
	private boolean checkGroup(int id, Group group) {
		if(userMap.get(id) != group) {
			System.out.println("This is no such " + group + " object by this ID");
			return false;
		}
		return true;
	}

	@Override
	public void deserializeData(){
		try {
			fileUserRepository.deserializeUserData();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void setFileUserRepository(FileUserRepository fileUserRepository) {
		this.fileUserRepository = fileUserRepository;
	}
}
