package org.hillel.it.mycity.persistence.repository;

import java.util.List;

import org.hillel.it.mycity.model.entity.Establishment;

public interface EstablishmentRepository {
	public void addEstablishment(Establishment establishment);
	public Establishment getEstablishmentById(int id);
	public List<Establishment> getAllEstablishment();
	public void deleteAllEstablishments();
	public void deleteEstablishmentById(int id);
}
