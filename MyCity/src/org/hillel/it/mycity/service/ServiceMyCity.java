package org.hillel.it.mycity.service;

import java.util.Date;
import java.util.List;

import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.Time;

public interface ServiceMyCity {
	public void addEstablishmentRestaurant(String setNameOfEstablishment,String addressOfEstablishment);
	public void addEstablishmentNightClub(String setNameOfEstablishment,String addressOfEstablishment);
	public void addEstablishmentCinema(String setNameOfEstablishment,String addressOfEstablishment);
	public void getEstablishmentById(int id);
	public List<Establishment> getAllEstablishment(List<Establishment> establishments);
	public boolean deleteAllEstablishments(List<Establishment> establishments);
	public boolean deleteEstablishmentById(int id);
	//Administrator and Moderator
	public void deleteComment(int id);
	//RegistratedUser
	public void writeCommet(String comment);
}
