package org.hillel.it.mycity.model.entity;

import java.util.Date;

public class Assessment extends BaseEntity{
	
	private int assessment;
	private Establishment establishment;
	
	public void setAssessment(int assessment) {
		this.assessment = assessment;
	}
	
	public int getAssessment() {
		return assessment;
	}
	
	public void setEstablishment(Establishment establishment) {
		if(checkDataNotNull(this.establishment)) {
			System.out.println("You can not add additional Establishment to this Assessment");
			return;
		}
		this.establishment = establishment;
	}
	
	public void checkEstablishment(Establishment establishment) {
		if(!this.establishment.equals(establishment) ) {
			throw new RuntimeException("Incorrect Establishment");
		}
	}
}
