package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Restaurant extends RestaurantsAndNightClubs{
	
	public Restaurant(Administrator administrator){
		
		setId();
		setCreateDate(new Date());
		setCreatedBy(administrator);
		assessmentsOfEstablishment = new ArrayList<>();
		commentsOfEstablishment = new ArrayList<>();
		
	}
}
