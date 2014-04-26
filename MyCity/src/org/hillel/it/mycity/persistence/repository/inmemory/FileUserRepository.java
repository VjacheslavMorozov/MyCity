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

public class FileUserRepository extends InMemoryUserRepository implements UserRepository{
	
	private File file;
	
	public FileUserRepository() {
		super();
		file = new File("store.bin");
	}
	private void sereializeUserData() throws IOException {
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
	
	private void deserializeUserData() throws IOException, ClassNotFoundException {
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
