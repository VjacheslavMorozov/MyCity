package org.hillel.it.mycity.model.entity;

public class Restaurant extends RestaurantsAndNightClubs{
	
	public String getRestaurantSQLData() {
		String restaurantEstablishment = "restaurantEstablishment = (SELECT MAX(idEstablishment) FROM Establishment)";
		int stringLength = restaurantEstablishment.length();
		restaurantEstablishment += super.getRestAndNCSQLData();
		if(stringLength == restaurantEstablishment.length()) {
			return "";
		} else {
			return restaurantEstablishment;
		}
	}
}
