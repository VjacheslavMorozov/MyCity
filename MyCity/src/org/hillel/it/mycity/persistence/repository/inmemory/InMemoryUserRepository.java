package org.hillel.it.mycity.persistence.repository.inmemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.UserRepository;

public class InMemoryUserRepository implements UserRepository, Serializable{
	
	private static final long serialVersionUID = 2L;
	private List<Administrator> administrators;
	private List<Moderator> moderators;
	private List<User> users;
	private Map<Integer, Group> userMap;
	private int maxId;
	private File file;
	
	public InMemoryUserRepository() {
		administrators = new ArrayList<>();
		moderators = new ArrayList<>();
		users = new ArrayList<>();
		userMap = new HashMap<Integer, Group>();
		maxId = 1;
		file = new File("storeNew.bin");
	}

	@Override
	public void addUser(User user) {
		validUser(user);
		user.setGroup(Group.User);
		userMap.put(maxId, Group.User);
		user.setId(maxId++);
		users.add(user);
	}

	@Override
	public void addModerator(Moderator moderator) {
		validUser(moderator);
		moderator.setGroup(Group.Moderator);
		userMap.put(maxId, Group.Moderator);
		moderator.setId(maxId++);
		moderators.add(moderator);
	}

	@Override
	public void addAdministrator(Administrator administrator) {
		validUser(administrator);
		administrator.setGroup(Group.Administrator);
		userMap.put(maxId, Group.Administrator);
		administrator.setId(maxId++);
		administrators.add(administrator);
	}

	@Override
	public void deleteUser(int id) {
		validId(id);
		
		switch (userMap.get(id)) {
		case User:
			objectNotNull(users);
			Iterator<User> iteratorUsers = users.iterator();
			while(iteratorUsers.hasNext()) {
				if(iteratorUsers.next().getId() == id) {
					iteratorUsers.remove();
					return;
				}
			}
			break;
		case Moderator:
			objectNotNull(moderators);
			Iterator<Moderator> iteratorModerators = moderators.iterator();
			while (iteratorModerators.hasNext()) {
				if(iteratorModerators.next().getId() == id) {
					iteratorModerators.remove();
					return;
				}
			}
			break;
		case Administrator:
			objectNotNull(administrators);
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
		objectNotNull(users);
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
		objectNotNull(moderators);
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
		objectNotNull(administrators);
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
	
	private <T extends List>void objectNotNull(T t) {
		if(t.isEmpty()) {
			throw new NullPointerException("ArrayLists is empty");
		}
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
	
	public void sereializeUserData() throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(administrators);
		oos.writeObject(moderators);
		oos.writeObject(users);
		oos.writeObject(userMap);
		oos.writeInt(maxId);
		
		oos.flush();
		oos.close();
	}
	
	public void deserializeUserData() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		administrators = (List<Administrator>) ois.readObject();
		moderators = (List<Moderator>) ois.readObject();
		users = (List<User>) ois.readObject();
		userMap = (Map<Integer, Group>) ois.readObject();
		maxId = ois.readInt();
		ois.close();
	}
}
