package org.hillel.it.mycity.model.entity;

import java.util.Date;

public class Comment extends BaseEntity{
	
	private int commentAssessment;
	private String comment;
	private boolean needToModerate;
	
	Comment(Person user) {
		setId();
		setCreateDate(new Date());
		setCreatedBy(user);
		commentAssessment = 0;
		needToModerate = false;
	}
	
	public boolean checkUser(Person user) {
		if(getCreatedBy().getId() != user.getId() && !user.toString().contains("Administrator")) {
			return false;
		}
		return true;
	}
	
	public void setComment(String comment, Person user) {
		if(!checkUser(user)) {
			throw new RuntimeException("This user cannot set or change this Comment");
		}
		this.comment = comment;
		setModifiedDate(new Date());
		setModifiedBy(user);
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setCommentPositiveAssessment(Person user) {
		if(!checkUser(user)) {
			throw new RuntimeException("This user cannot set or change this Comment");
		}
		++commentAssessment;
	}
	
	public void setCommentNegativeAssessment(Person user) {
		if(!checkUser(user)) {
			throw new RuntimeException("This user cannot set or change this Comment");
		}
		--commentAssessment;
	}
	
	public int getCommentAssessment() {
		return commentAssessment;
	}
	
	public void setCommentToModerate(Person user) {
		if(user.toString().contains("RegistratedUser")) {
			throw new RuntimeException("This user cannot set comment to moderation");
		}
		needToModerate = true;
		
	}
	
	public boolean checkCommentForModeration() {
		if(needToModerate) {
			return true;
		}
		return false;
	}
}
