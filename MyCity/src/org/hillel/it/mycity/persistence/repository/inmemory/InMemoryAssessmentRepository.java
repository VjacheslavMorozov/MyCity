package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.hillel.it.mycity.model.entity.Assessment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.persistence.repository.AssessmentRepository;

public class InMemoryAssessmentRepository implements AssessmentRepository{
	
	private List<Assessment> assessments;
	private List<Assessment> unmodifiableAssessments;
	private int maxId;
	
	public InMemoryAssessmentRepository() {
		assessments = new ArrayList<>();
		unmodifiableAssessments = Collections.unmodifiableList(assessments);
		maxId = 1;
	}

	@Override
	public void addAssessment(Assessment assessment) {
		if(validAssessment(assessment)) {
			throw new RuntimeException("This assessment is already exist in memory");
		}
		assessment.setId(maxId++);
		assessments.add(Objects.requireNonNull(assessment, "This object does not cointains any information"));
	}
	
	public boolean validAssessment(Assessment assessment) {
		if(assessment.getId() > 0) {
			return false;
		}
		return true;
	}

	@Override
	public void deleteAssessment(int id) {
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
		Iterator<Assessment> iterator = assessments.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().equals(user)) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteAssessment(Establishment establishment) {
		Iterator<Assessment> iterator = assessments.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().checkEstablishment(establishment)) {
				iterator.remove();
			}
		}
	}

	@Override
	public Assessment getAssessment(int id) {
		for(Assessment assessment: assessments){
			if(assessment.getId() == id) {
				return assessment;
			}
		}
		return null;
	}

	@Override
	public List<Assessment> getAssessments(Person user) {
		List<Assessment> assessments = new ArrayList<>();
		for(Assessment assessment: unmodifiableAssessments){
			if(assessment.getCreatedBy().equals(user)) {
				assessments.add(assessment);
			}
		}
		return assessments;
	}

	@Override
	public List<Assessment> getAssessments(Establishment establishment) {
		List<Assessment> assessments = new ArrayList<>();
		for(Assessment assessment: unmodifiableAssessments){
			if(assessment.checkEstablishment(establishment)) {
				assessments.add(assessment);
			}
		}
		return assessments;
	}

	@Override
	public List<Assessment> getAssessments() {
		return unmodifiableAssessments;
	}
}
