package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Restaurant extends RestaurantsAndNightClubs{
	
	public Restaurant(Administrator administrator){
		super(administrator);
		assessmentsOfEstablishment = new ArrayList<>();
		commentsOfEstablishment = new ArrayList<>();
		
	}
}
