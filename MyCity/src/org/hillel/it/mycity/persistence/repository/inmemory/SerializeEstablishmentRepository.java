package org.hillel.it.mycity.persistence.repository.inmemory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;

@Deprecated
public class SerializeEstablishmentRepository implements EstablishmentRepository{
	private List<Restaurant> restaurants;
	private List<NightClub> nightClubs;
	private ArrayList<Cinema> cinemas;
	private int maxId;
	private File serializeRestaurantsFile;
	private File serializeNightClubsFile;
	private File serializeCinemasFile;
	private File serializeMaxIdFile;
	private FileOutputStream stream;
	private byte[] data;
	
	
	public SerializeEstablishmentRepository(){
		restaurants = new ArrayList<>();
		nightClubs = new ArrayList<>();
		cinemas = new ArrayList<>();
		maxId = 1;
		serializeRestaurantsFile = new File("/Users/artemvlasov/git/MyCity/MyCity/SerializeData/serializeRestaurants.bin");
		serializeNightClubsFile = new File("/Users/artemvlasov/git/MyCity/MyCity/SerializeData/serializeNightClubs.bin");
		serializeCinemasFile = new File("/Users/artemvlasov/git/MyCity/MyCity/SerializeData/serializeCinemas.bin");
		serializeMaxIdFile = new File("/Users/artemvlasov/git/MyCity/MyCity/SerializeData/maxId.bin");
	}
	

	@Override
	public void addEstablishmentCinema(Cinema cinema){
		try {
			stream = new FileOutputStream(serializeCinemasFile);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		cinemas.add(cinema);
		cinema.setId(maxId);
		SerializationUtils.serialize(cinemas, stream);
		try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addEstablishmentNightClub(NightClub nightClub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEstablishmentRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cinema> getAllCinemaEstablishment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NightClub> getAllNightClubEstablishment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> getAllRestaurantEstablishment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEstablishmentByType(String establishmentType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllEstablishments() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEstablishmentById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T getEstablishmentById(int id, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void deserializeData() throws IOException{
		data = FileUtils.readFileToByteArray(serializeCinemasFile);
		cinemas  = SerializationUtils.deserialize(data);
	}
}
