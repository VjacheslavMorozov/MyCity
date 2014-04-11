package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Establishment extends BaseEntity{
	private String nameOfEstablishment;
	private String addressOfEstablishment;
	private String telephoneOfEstablishment; //формат (0482) 34-56-15, можно добавить форматирование по
	private String descriptionOfEstablishment;
	private List<Comment> commentsOfEstablishment;
	private List<Assessment> assessmentsOfEstablishment;
	
	public Establishment() {
		commentsOfEstablishment = new ArrayList<>();
		assessmentsOfEstablishment = new ArrayList<>();
	}
	
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
		if(!checkTelephoneOfEstablishment(telephoneOfEstablishment)) {
			System.out.println("Incorrect format");
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
	/**
	 * 
	 * @param comment
	 * @deprecated
	 */
	public void setCommentForEstablishment(String comment) {
		Comment establishmentComment = new Comment();
		try {
			establishmentComment.setComment(comment);
		} catch (RuntimeException e) {
			e.fillInStackTrace();
		}
		establishmentComment.setComment(comment);
		commentsOfEstablishment.add(establishmentComment);
	}
	
	public void changeCommentForEstbalishment(String commentNew, int id) {
		checkId(id);
		for(Comment comment: commentsOfEstablishment) {
			if(comment.getId() == id) {
				try {
					comment.setComment(commentNew);
				} catch (RuntimeException e) {
					e.fillInStackTrace();
				}
				comment.setComment(commentNew);
				return;
			}
		}
	}
	
	public String getCommentById(int id) {
		checkId(id);
		for(Comment comment: commentsOfEstablishment) {
			if(comment.getId() == id) {
				return comment.getComment();
			}
		}
		
		return null;
	}
	
	public void setPositiveAssessmentToComment(int id, Person user) {
		checkId(id);
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
		checkId(id);
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
	
	public void setAssessmentToEstablishment(int assessment) {
		Assessment establishmentAssessment = new Assessment();
		try {
			establishmentAssessment.setAssessment(assessment);
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		establishmentAssessment.setAssessment(assessment);
		assessmentsOfEstablishment.add(establishmentAssessment);
	}
	
	public int getAssessmentById(int id) {
		checkId(id);
		for(Assessment assessment: assessmentsOfEstablishment) {
			if(assessment.getId() == id) {
				return assessment.getAssessment();
			}
		}
		return 0;
	}
	
	public void changeAssessmentForEstablishment(int assessmentNew, int id) {
		checkId(id);
		for(Assessment assessment: assessmentsOfEstablishment) {
			if(assessment.getId() == id) {
				try {
					assessment.setAssessment(assessmentNew);
				} catch (Exception e) {
					e.fillInStackTrace();
				}
				assessment.setAssessment(assessmentNew);
				return;
			}
		}
	}
	
	/**
	 * Check insert telephone number on regex. Standart format 0939580099
	 * @param telephoneOfEstablishment
	 * @return true if telephone number is in standart format
	 */
	public boolean checkTelephoneOfEstablishment(String telephoneOfEstablishment) {
		Pattern telephonePattern = Pattern.compile("(^0{1} [6][3678] | [9][1-9] | 39 | 48 | 50) \\d{7}");
		Matcher telephoneMatcher = telephonePattern.matcher(telephoneOfEstablishment);
		return telephoneMatcher.find();
	}
}
