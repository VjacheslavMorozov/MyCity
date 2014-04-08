package org.hillel.it.mycity.model.entity;

import java.util.Date;

public class Assessment extends BaseEntity{
	
	private int assessment;
	
	public Assessment(Person person) {
		super(person);
	}
	
	public void setAssessment(int assessment, Person user) {
		if(getCreatedBy().getId() != user.getId()) {
			throw new RuntimeException("This user cannot change assessment");
		}
		this.assessment = assessment;
		setModifiedBy(user);
		setModifiedDate(new Date());
	}
	
	public int getAssessment() {
		return assessment;
	}
}
