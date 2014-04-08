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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrator> getAllAdministrators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Moderator> getAllModerators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllRegistratedUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return 0;
		
	}

}
