package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.mycity.model.entity.BaseEntity;
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
	public Establishment getEstablishmentById(int id) {
		
		int index = 0;
		if(id == 0){
			System.out.println("Incorrect id");
			return null;
			
		}
		for(Establishment establishment: establishments){
			if(establishment.getId() == id){
				return establishments.get(index);
			}
			index++;
		}
		return null;
	}
	@Override
	public List<Establishment> getAllEstablishment() {
		
		if(establishments.isEmpty()){
			System.out.println("List of Establishment is epmty");
			return null;
		}
		return establishments;
		
	}
	
	@Override
	public void deleteAllEstablishments() {
		
		if(establishments.isEmpty()){
			System.out.println("List of Establishment is epmty");
			return;
		}
		establishments.clear();
		return;
		
	}
	
	@Override
	public void deleteEstablishmentById(int id) {
		
		int index = 0;
		if(establishments.isEmpty()){
			System.out.println("List is empty");
			return;
		}
		else if(id == 0){
			System.out.println("Incorrect id");
		}
		for(Establishment establishment: establishments){
			
			if(establishment.getId() == id){
				
				establishments.remove(index);
				return;
				
			}
			
			index++;
			
		}
		return;
		
	}
	
}
