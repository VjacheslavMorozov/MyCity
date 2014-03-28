package org.hillel.it.mycity.persistence.repository;

import org.hillel.it.mycity.model.entity.Establishment;

public interface EstablishmentRepository {
	public Establishment addEstablishmentRestaurant(String setNameOfEstablishment,String addressOfEstablishment);
	public Establishment addEstablishmentNightClub(String setNameOfEstablishment,String addressOfEstablishment);
	public Establishment addEstablishmentCinema(String setNameOfEstablishment,String addressOfEstablishment);
	public int deleteEstablishmentById(int id);
}
