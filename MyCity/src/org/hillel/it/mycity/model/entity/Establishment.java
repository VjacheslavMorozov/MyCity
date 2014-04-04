package org.hillel.it.mycity.model.entity;

import java.util.List;

public abstract class Establishment extends BaseEntity{
	private String nameOfEstablishment;
	private String addressOfEstablishment;
	private String telephoneOfEstablishment; //формат (0482) 34-56-15, можно добавить форматирование по
	private String descriptionOfEstablishment;
	protected List<Comment> commentsOfEstablishment;
	protected List<Assessment> assessmentsOfEstablishment;
	//массив оценок от 1 - 10, из этого массива вычисляется средняя и показывается на странице заведения.
	
	public void setNameOfEstablishment(String nameOfEstablishment){
		this.nameOfEstablishment = nameOfEstablishment;
	}
	
	public String getNameOfEstablishment() {
		return nameOfEstablishment;
	}
	
	public void setAddressOfEstablishment(String addressOfEstablishment) {
		this.addressOfEstablishment = addressOfEstablishment;
	}
	
	public String getAddressOfEstablishment() {
		return addressOfEstablishment;
	}
	
	public void setTelephoneOfEstablishment(String telephoneOfEstablishment) {
		if(telephoneOfEstablishment.length() != 10){
			System.out.println("Incorrect telephone number. It`s must be ten numbers");
			return;
		}
		this.telephoneOfEstablishment = telephoneOfEstablishment;
	}
	
	public String getTelephoneOfEstablishment() {
		return telephoneOfEstablishment;
	}
	
	public void setDescriptionOfEstablishment(String descriptionOfEstablishment) {
		this.descriptionOfEstablishment = descriptionOfEstablishment;
	}
	
	public String getDescriptionOfEstablishment() {
		return descriptionOfEstablishment;
	}
	
	public void setCommentForEstablishment(String comment, Person user) {
		Comment establishmentComment = new Comment(user);
		try {
			establishmentComment.setComment(comment, user);
		} catch (RuntimeException e) {
			e.fillInStackTrace();
		}
		establishmentComment.setComment(comment, user);
		commentsOfEstablishment.add(establishmentComment);
	}
	
	public void changeCommentForEstbalishment(String commentNew, int id, Person user) {
		if(id < 1 || id > getIdCount()) {
			throw new RuntimeException("Incorrect id");
		}
		for(Comment comment: commentsOfEstablishment) {
			if(comment.getId() == id) {
				try {
					comment.setComment(commentNew, user);
				} catch (RuntimeException e) {
					e.fillInStackTrace();
				}
				comment.setComment(commentNew, user);
				return;
			}
		}
	}
	
	public String getCommentById(int id) {
		if(id < 1 || id > getIdCount()) {
			throw new RuntimeException("Incorrect id");
		}
		
		for(Comment comment: commentsOfEstablishment) {
			if(comment.getId() == id) {
				return comment.getComment();
			}
		}
		
		return null;
	}
	
	public void setPositiveAssessmentToComment(int id, Person user) {
		if(id < 1 || id > getIdCount()) {
			throw new RuntimeException("Incorrect id");
		}
		
		for(Comment comment: commentsOfEstablishment) {
			if(comment.getId() == id) {
				try {
					comment.setCommentPositiveAssessment(user);
				} catch (RuntimeException e) {
					e.fillInStackTrace();
				}
				comment.setCommentPositiveAssessment(user);
				return;
			}
		}
	}
	
	public void setNegativeAssessmentToComment(int id, Person user) {
		if(id < 1 || id > getIdCount()) {
			throw new RuntimeException("Incorrect id");
		}
		
		for(Comment comment: commentsOfEstablishment) {
			if(comment.getId() == id) {
				try {
					comment.setCommentNegativeAssessment(user);
				} catch (RuntimeException e) {
					e.fillInStackTrace();
				}
				comment.setCommentNegativeAssessment(user);
				return;
			}
		}
	}
	
	public void setAssessmentToEstablishment(int assessment, Person user) {
		Assessment establishmentAssessment = new Assessment(user);
		try {
			establishmentAssessment.setAssessment(assessment, user);
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		establishmentAssessment.setAssessment(assessment, user);
		assessmentsOfEstablishment.add(establishmentAssessment);
	}
	
	public int getAssessmentById(int id) {
		if(id < 1 || id > getIdCount()) {
			throw new RuntimeException("Incorrect id");
		}
		
		for(Assessment assessment: assessmentsOfEstablishment) {
			if(assessment.getId() == id) {
				return assessment.getAssessment();
			}
		}
		return 0;
	}
	
	public void changeAssessmentForEstablishment(int assessmentNew, int id, Person user) {
		if(id < 1 || id > getIdCount()) {
			throw new RuntimeException("Incorrect id");
		}
		
		for(Assessment assessment: assessmentsOfEstablishment) {
			if(assessment.getId() == id) {
				try {
					assessment.setAssessment(assessmentNew, user);
				} catch (Exception e) {
					e.fillInStackTrace();
				}
				assessment.setAssessment(assessmentNew, user);
				return;
			}
		}
		
	}
}
