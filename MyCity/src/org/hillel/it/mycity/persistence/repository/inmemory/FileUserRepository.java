package org.hillel.it.mycity.persistence.repository.inmemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.UserRepository;

public class FileUserRepository extends InMemoryUserRepository{
	
	private File file;
	private InMemoryUserRepository inMemoryUserRepository;
	
	public FileUserRepository() {
		super();
		file = new File("store.bin");
	}
	public void sereializeUserData() throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		//SerializationUtils.serialize(this, fos);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(administrators);
		oos.writeObject(moderators);
		oos.writeObject(users);
		oos.writeObject(userMap);
		oos.writeInt(maxId);
		oos.flush();
		oos.close();
		fos.close();
	}
	
	public void deserializeUserData() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		//SerializationUtils.deserialize(fis);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		administrators = (List<Administrator>) ois.readObject();
		moderators = (List<Moderator>) ois.readObject();
		users = (List<User>) ois.readObject();
		userMap = (Map<Integer, Group>) ois.readObject();
		maxId = ois.readInt();
		ois.close();
	}
}
