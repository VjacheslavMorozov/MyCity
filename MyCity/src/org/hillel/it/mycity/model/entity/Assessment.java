package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Assessment {
	
	/*
	 * @timur 
	 * 
	 * Как понимаю объект класса Assessment представляет одну оценку одного пользователя на одно заведение. 
	 * 
	 *  Считаю, что тут точно должно быть 3 поля:  
	 *  user_id, establishment_id и assessment.
	 * 
	 */
	
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
