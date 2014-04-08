package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.UserRepository;

public class InMemoryUserRepository implements UserRepository{
	
	private List<Administrator> administrators;
	private List<Moderator> moderators;
	private List<User> users;
	
	public InMemoryUserRepository() {
		administrators = new ArrayList<>();
		moderators = new ArrayList<>();
		users = new ArrayList<>();
	}

	@Override
	public void addRegistratedUser(User user) {
		users.add(user);
	}

	@Override
	public void addModerator(Moderator moderator) {
		moderators.add(moderator);
	}

	@Override
	public void addAdministrator(Administrator administrator) {
		administrators.add(administrator);
	}

	@Override
	public void deleteUserById(int id) {
		if(id < 1 || id > getLastId()) {
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
	public <T> T getUserById(int id, Class<T> type) {
		if(id < 1) {
			System.out.println("Incorrect id");
			return null;
		}
		if(type.toString().contains("Administrator")) {
			if(administrators.isEmpty()) {
				System.out.println("Administrators array is empty");
				return null;
			}
			for(int i = 0; i < administrators.size(); i++) {
				if(administrators.get(i).getId() == id) {
					return type.cast(administrators.get(i));
				}
			}
		} else if(type.toString().contains("Moderator")) {
			if(moderators.isEmpty()) {
				System.out.println("Moderators array is empty");
				return null;
			}
			for(int i = 0; i < moderators.size(); i++) {
				if(moderators.get(i).getId() == id) {
					return type.cast(moderators.get(i));	
				}
			}
		} else if(type.toString().contains("User")){
			if(users.isEmpty()) {
				System.out.println("Users array is empty");
				return null;
			}
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getId() == id) {
					return type.cast(users.get(i));
				}
			}
		}
		return null;
	}

	@Override
	public List<Administrator> getAllAdministrators() {
		if(administrators.isEmpty()) {
			return null;
		}
		return administrators;
	}

	@Override
	public List<Moderator> getAllModerators() {
		if(moderators.isEmpty()) {
			return null;
		}
		return moderators;
	}

	@Override
	public List<User> getAllRegistratedUsers() {
		if(users.isEmpty()) {
			return null;
		}
		return users;
	}

	@Override
	public int getLastId() {
		if(administrators.isEmpty() && moderators.isEmpty() && users.isEmpty()) {
			System.out.println("There is no Establishment elements");
			return 0;
		}
		if(!administrators.isEmpty()) {
			return administrators.get(administrators.size()-1).getIdCount();
		} else if(!moderators.isEmpty()) {
			return moderators.get(moderators.size()-1).getIdCount();
		} else {
			return users.get(users.size()-1).getIdCount();
		}
	}

	@Override
	public void deleteAllUsers() {
		administrators.clear();
		moderators.clear();
		users.clear();
	}

}
