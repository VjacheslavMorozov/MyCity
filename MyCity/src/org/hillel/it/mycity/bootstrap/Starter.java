package org.hillel.it.mycity.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		InMemoryEstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		ServiceImpl serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository);
		
		serviceImpl.addEstablishmentCinema("Planeta-Kino", "Rivera");
		serviceImpl.addEstablishmentNightClub("Palladium", "Italian blv.");
		serviceImpl.addEstablishmentRestaurant("Steak", "Deribasovskaya str.");
		
		//проблема
		/*Establishment cinema = new Cinema();
		cinema = serviceImpl.getEstablishmentById(0);
		System.out.println(cinema.getNameOfEstablishment());*/
		
		List<Establishment> establishments = new ArrayList<>();
		establishments = serviceImpl.getAllEstablishment();
		
		for(Establishment establishment: establishments){
			
			System.out.println(establishment.getNameOfEstablishment());
			
		}
		
		serviceImpl.deleteEstablishmentById(1);
		
		for(Establishment establishment: establishments){
			
			System.out.println(establishment.getNameOfEstablishment());
			
		}
		
		serviceImpl.deleteAllEstablishments();
	}
}
