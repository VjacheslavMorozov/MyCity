package org.hillel.it.mycity.model.entity;

public abstract class RestaurantsAndNightClubs extends Establisment{
	private AdditionalServices additionalServices; //я думаю, что можно создать класс с дополнительными услугами.
	private Time timeOpen;
	private Time timeClose;
	private int averageCheck;
}
