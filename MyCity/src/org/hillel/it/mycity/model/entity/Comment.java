package org.hillel.it.mycity.model.entity;

import java.util.Date;

	/*Есть два вариант, либо сделать Commet, как класс, который создается единажды для каждого заведения 
	*или как класс для каждого комментария, в первом случае у меня возникла проблема из-за того, что
	* у одного комменты может быть несколько оценок commentAssessment. Идеально для этого был бы 2мерный
	* массив*/
	
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
	
	public Comment(Person person) {
		super(person);
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
