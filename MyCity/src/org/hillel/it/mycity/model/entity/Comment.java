package org.hillel.it.mycity.model.entity;

import java.util.Date;
	/*
	 * @timur Думаю объект класса Comment должен представлять 
	 * один комментарий. Один комментарий - это комментарий 
	 * одного пользователя (user_id) к одному заведению (establishment_id).
	 * 
	 * Потом уже будем делать выборки этих комментариев как угодно: 
	 * 1) Список всех комментриев к заведению. Например, это будет поле класса Establishment.
	 * 2) Список всех комментариев пользователя. Например, это будет поле класса RegisteredUser. 
	 * 
	 */
public class Comment extends BaseEntity{
	
	private int commentAssessment;
	private String comment;
	private boolean needToModerate;
	
	public Comment() {
		commentAssessment = 0;
		needToModerate = false;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setCommentPositiveAssessment(Person user) {
		++commentAssessment;
	}
	
	public void setCommentNegativeAssessment(Person user) {
		--commentAssessment;
	}
	
	public int getCommentAssessment() {
		return commentAssessment;
	}
	
	public void setCommentToModerate(Person user) {
		needToModerate = true;
		
	}
	
	public boolean checkCommentForModeration() {
		if(needToModerate) {
			return true;
		}
		return false;
	}
}
