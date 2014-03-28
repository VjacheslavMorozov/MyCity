package org.hillel.it.mycity.model.entity;

public abstract class RestaurantsAndNightClubs extends Establishment{
	//protected AdditionalService additionalService; //я думаю, что можно создать класс с дополнительными услугами.
	protected Time timeOpen;
	protected Time timeClose;
	protected int averageCheck;
}
