package org.hillel.it.mycity.persistence.repository.inmemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.persistence.repository.UserRepository;

public class SerializationUserRepository extends InMemoryUserRepository{
	
	private File file;
	
	public SerializationUserRepository() {
		file = new File("store.bin");
	}
	public void serializeData() throws IOException {
	
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(getAdministratorsForSerialization());
		oos.flush();
		oos.close();
	}
	
	public void deserializeData() throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		setAdministratorsDeserialization((List<Administrator>) ois.readObject());
		ois.close();
	}
}
