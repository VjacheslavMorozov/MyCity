package org.hillel.it.mycity.service;

import java.util.Date;
import java.util.List;

import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.Time;

public interface ServiceMyCity {
	public void addEstablishmentRestaurant(String nameOfEstablishment,String addressOfEstablishment);
	public void addEstablishmentNightClub(String nameOfEstablishment,String addressOfEstablishment);
	public void addEstablishmentCinema(String nameOfEstablishment,String addressOfEstablishment);
	public Establishment getEstablishmentById(int id);
	public List<Establishment> getAllEstablishment();
	public void deleteAllEstablishments();
	public void deleteEstablishmentById(int id);
	//Administrator and Moderator
	public void deleteComment(int id);
	//RegistratedUser
	public void writeCommet(String comment);
}
