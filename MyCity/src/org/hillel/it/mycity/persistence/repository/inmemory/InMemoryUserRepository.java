package org.hillel.it.mycity.persistence.repository.inmemory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.UserRepository;

public class InMemoryUserRepository implements UserRepository, Serializable{
	
	private static final long serialVersionUID = 2L;
	protected List<Person> persons;
	protected Map<Integer, Group> userMap;
	protected Set<String> emailSet;
	protected int maxId;
	
	public InMemoryUserRepository() {
		persons = new ArrayList<>();
		userMap = new HashMap<Integer, Group>();
		emailSet = new HashSet<String>();
		maxId = 1;
	}

	@Override
	public void addUser(User user) {
		validUser(user);
		validEmail(user.getEmail());
		user.setGroup(Group.User);
		userMap.put(maxId, Group.User);
		user.setId(maxId++);
		persons.add(user);
		flush();
	}

	@Override
	public void addModerator(Moderator moderator) {
		validUser(moderator);
		validEmail(moderator.getEmail());
		moderator.setGroup(Group.Moderator);
		userMap.put(maxId, Group.Moderator);
		moderator.setId(maxId++);
		persons.add(moderator);
		flush();
	}

	@Override
	public void addAdministrator(Administrator administrator) {
		validUser(administrator);
		validEmail(administrator.getEmail());
		administrator.setGroup(Group.Administrator);
		userMap.put(maxId, Group.Administrator);
		administrator.setId(maxId++);
		persons.add(administrator);
		flush();
	}

	@Override
	public void deletePerson(int id) {
		validId(id);
		for(int i = 0; i < persons.size(); i++) {
			if(persons.get(i).getId() == id) {
				persons.remove(i);
			}
		}
	}

	@Override
	public List<Person> getPersons() {
		return Collections.unmodifiableList(persons);
	}

	@Override
	public void deletePersons() {
		persons.clear();
	}

	@Override
	public User getUser(int id) {
		checkGroup(id, Group.User);
		for(Person person : persons) {
			if(person.getId() == id) {
				return (User) person;
			}
		}
		return null;
	}
	
	@Override
	public Administrator getAdministrator(int id) {
		checkGroup(id, Group.Administrator);
		for(Person person : persons) {
			if(person.getId() == id) {
				return (Administrator) person;
			}
		}
		return null;
	}
	
	@Override
	public Moderator getModerator(int id) {
		checkGroup(id, Group.Moderator);
		for(Person person : persons) {
			if(person.getId() == id) {
				return (Moderator) person;
			}
		}
		return null;
	}
	
	@Override
	public void deserializeData(){}
	
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
	
	private void validEmail(String email) {
		if(emailSet.contains(email)) {
			throw new RuntimeException("User with this email is already exist");
		}
		emailSet.add(email);
	}
	
	public void flush(){}
}
