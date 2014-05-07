package org.hillel.it.mycity.persistence.repository.inmemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.UserRepository;

public class FileUserRepository extends InMemoryUserRepository implements UserRepository {
	
	private File file;
	
	public FileUserRepository(){
		super();
	}
	
	protected void sereializeUserData() {
		file = new File("person.bin");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		SerializationUtils.serialize((Serializable) this.persons, fos);
	}
	
	protected void deserializeUserData() {
		FileInputStream fis = null;
		try {
			file = new File("person.bin");
			if(file.exists()) {
				fis = new FileInputStream(file);
				persons = SerializationUtils.deserialize(fis);
				for(Person person : persons) {
					if(person.getId() > maxId) {
						maxId = person.getId() + 1;
					}
					userMap.put(person.getId(), person.getGroup());
					emailSet.add(person.getEmail());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	@Override
	public void flush() {
		sereializeUserData();
	}
	
	@Override
	public void deserializeData() {
		deserializeUserData();
	}
}
