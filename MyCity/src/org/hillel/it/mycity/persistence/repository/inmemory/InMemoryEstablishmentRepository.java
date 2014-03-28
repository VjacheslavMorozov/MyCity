package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.mycity.model.entity.Establishment;

public class InMemoryEstablishmentRepository {
	private List<Establishment> establishment;
	public InMemoryEstablishmentRepository() {
		establishment = new ArrayList<>();
	}
	public void addRestaurant(Establishment restaurant){
		
		establishment.add(restaurant);
		
	}
	public void addNightClub(Establishment nightClub){
		
		establishment.add(nightClub);
		
	}
	public void addCinema(Establishment cinema){
		
		establishment.add(cinema);
		
	}
	public void getIndex(int index){
		establishment.remove(index);
	}
	public int returnListSize(){
		return establishment.size();
	}
}
