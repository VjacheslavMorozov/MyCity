package org.hillel.it.mycity.persistence.repository;

import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Person;

public interface CommentRepository {
	public void addComment(Comment comment);
	public void deleteCommentById(int id);
	public void deleteCommentsByUser(Person user);
	public Comment getCommentById(int id);
}
