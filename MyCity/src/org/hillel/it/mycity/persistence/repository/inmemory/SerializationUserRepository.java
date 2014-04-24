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

public class SerializationUserRepository{
	
	private File file;
	private UserRepository inMemoryUserRepository;
	
	public SerializationUserRepository(UserRepository inMemoryUserRepository) {
		file = new File("store.bin");
		this.inMemoryUserRepository = inMemoryUserRepository;
	}
	public void serializeData() throws IOException {
	
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(inMemoryUserRepository);
		oos.flush();
		oos.close();
	}
	
	public void deserializeData() throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ois.readObject();
		ois.close();
	}
}
