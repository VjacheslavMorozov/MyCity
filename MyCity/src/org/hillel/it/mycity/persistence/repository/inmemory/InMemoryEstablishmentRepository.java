package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;

public class InMemoryEstablishmentRepository implements EstablishmentRepository{
	private List<Establishment> establishments;
	
	public InMemoryEstablishmentRepository() {
		
		establishments = new ArrayList<>();
		
	}
	
	@Override
	public void addEstablishment(Establishment establishment) {
		
		establishments.add(establishment);
		
	}
	@Override
	public Establishment getEstablishmentById(int index) {
		
		if(index > establishments.size()-1){
			
			System.out.println("No an a Establishment by this index");
			return null;
			
		}
		return establishments.get(index);
		
	}
	@Override
	public List<Establishment> getAllEstablishment() {
		
		return establishments;
		
	}
	@Override
	public boolean deleteAllEstablishments() {
		
		establishments.clear();
		return true;
		
	}
	@Override
	public boolean deleteEstablishmentById(int index) {
		
		if(index > establishments.size()-1){
			
			System.out.println("No an a Establishment by this index");
			return false;
			
		}
		establishments.remove(index);
		return true;
		
	}
	
}
