package org.hillel.it.mycity.model.entity;

public class NightClub extends RestaurantsAndNightClubs{
	
	public String getNightClubSQLData() {
		String nightclubEstablishment = "nightclubEstablishment = (SELECT MAX(idEstablishment) FROM Establishment)";
		int stringLength  = nightclubEstablishment.length();
		nightclubEstablishment += super.getRestAndNCSQLData();
		if(stringLength == nightclubEstablishment.length()) {
			return "";
		} else {
			return nightclubEstablishment;
		}
	}
}
