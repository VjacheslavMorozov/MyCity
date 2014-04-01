package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Assessment {
	
	private List<Integer> assessments;
	protected double averageAssessment;
	protected int sumOfAssessment;
	
	public Assessment(){
		
		assessments = new ArrayList<>();
		averageAssessment = 0;
		sumOfAssessment = 0;
		
	}
	
	public void setAssessment(int assessment) {
		
		this.assessments.add(assessment);
		sumOfAssessment += assessment;
		
	}
	public double getAssessment() {
		
		return (double) sumOfAssessment/assessments.size();
		
	}
}
