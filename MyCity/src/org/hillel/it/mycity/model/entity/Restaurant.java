package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Restaurant extends RestaurantsAndNightClubs{
	public Restaurant(){
		
		setId();
		Date date = new Date();
		setCreateDate(date);
		//assessmentsOfEstablishment = new Assessment();
		//commentsOfEstablishment = new Comment();
		
	}
}
