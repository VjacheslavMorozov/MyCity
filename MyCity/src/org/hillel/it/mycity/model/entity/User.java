package org.hillel.it.mycity.model.entity;

import java.util.Date;

public class User extends Person{
	public Comment createComment(String userComment) {
		if(getId() == 0) {
			System.out.println("This user did not exist");
			return null;
		}
		Comment comment = new Comment();
		comment.setCreatedBy(this);
		comment.setComment(userComment);
		return comment;
	}
	
	//можно вынести в класс Person и сделать проверку на группы и на ID
	public Comment changeComment(Comment comment, String userComment) {
		if(comment.getCreatedBy().getId() != getId()) {
			System.out.println("This user cannot change this comment");
			return null;
		}
		comment.setComment(userComment);
		comment.setModifiedBy(this);
		comment.setModifiedDate(new Date());
		return comment;
	}
}
