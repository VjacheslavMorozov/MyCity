package org.hillel.it.mycity.model.entity;

import java.util.Date;

public class NightClub extends RestaurantsAndNightClubs{
	public NightClub(){
		
		setId();
		Date date = new Date();
		setCreateDate(date);
		//commentsOfEstablishment = new Comment();
		//assessmentsOfEstablishment = new Assessment();
		
	}
	/*Я думаю, что лучше создать отдельный класс под Оценки, так как, каждый пользователь может их менять
	*То есть каждый пользователь имеет свой ID, который показывает его оценку, эту оценку он может поменять
	*Соотвественно эту оценку нужно хранить, например в interface Map - один Id - Одна Assessment*/
}