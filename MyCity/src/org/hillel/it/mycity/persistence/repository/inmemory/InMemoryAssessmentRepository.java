package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.hillel.it.mycity.model.entity.Assessment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.persistence.repository.AssessmentRepository;

public class InMemoryAssessmentRepository implements AssessmentRepository{
	
	private List<Assessment> assessments;
	private int maxId;
	
	public InMemoryAssessmentRepository() {
		assessments = new ArrayList<>();
		maxId = 1;
	}

	@Override
	public void addAssessment(Assessment assessment) {
		if(assessment.getId() > 0) {
			System.out.println("This assessment is already exist in memory");
			return;
		}
		assessment.setId(maxId++);
		assessments.add(Objects.requireNonNull(assessment, "This object does not cointains any information"));
	}

	@Override
	public void deleteAssessment(int id) {
		if(!checkData()) {
			return;
		}
		Iterator<Assessment> iterator = assessments.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().getId() == id) {
				iterator.remove();
				return;
			}
		}
	}

	@Override
	public void deleteAssessment(Person user) {
		if(!checkData()) {
			return;
		}
		Iterator<Assessment> iterator = assessments.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().equals(user)) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteAssessment(Establishment establishment) {
		if(!checkData()) {
			return;
		}
		Iterator<Assessment> iterator = assessments.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().checkEstablishment(establishment)) {
				iterator.remove();
			}
		}
	}

	@Override
	public Assessment getAssessment(int id) {
		if(!checkData()) {
			return null;
		}
		for(Assessment assessment: assessments){
			if(assessment.getId() == id) {
				return assessment;
			}
		}
		return null;
	}

	@Override
	public List<Assessment> getAssessments(Person user) {
		if(!checkData()) {
			return null;
		}
		List<Assessment> newAssessments = new ArrayList<>();
		for(Assessment assessment: assessments){
			if(assessment.getCreatedBy().equals(user)) {
				newAssessments.add(assessment);
			}
		}
		return newAssessments;
	}

	@Override
	public List<Assessment> getAssessments(Establishment establishment) {
		if(!checkData()) {
			return null;
		}
		List<Assessment> newAssessments = new ArrayList<>();
		for(Assessment assessment: assessments){
			if(assessment.checkEstablishment(establishment)) {
				newAssessments.add(assessment);
			}
		}
		return newAssessments;
	}

	@Override
	public List<Assessment> getAssessments() {
		if(!checkData()) {
			return null;
		}
		return assessments;
	}

	public boolean checkData() {
		if(assessments.isEmpty()) {
			System.out.println("There is no data to delete");
			return false;
		}
		return true;
	}
}
