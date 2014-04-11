package org.hillel.it.mycity.model.entity;

import java.util.Date;

public class Assessment extends BaseEntity{
	
	private int assessment;
	private int personId;
	private int establishementId;
	
	public void setAssessment(int assessment) {
		this.assessment = assessment;
	}
	
	public int getAssessment() {
		return assessment;
	}
	
}
