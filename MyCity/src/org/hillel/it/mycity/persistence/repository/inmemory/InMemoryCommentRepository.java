package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.hillel.it.mycity.model.entity.Comment;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.Group;
import org.hillel.it.mycity.model.entity.Person;
import org.hillel.it.mycity.persistence.repository.CommentRepository;

//Подумать насчет оптимизации методов по удаление и добавлению объектов.

public class InMemoryCommentRepository implements CommentRepository{
	
	private List<Comment> comments;
	private int maxId;
	
	public InMemoryCommentRepository() {
		comments = new ArrayList<>();
		maxId = 1;
	}

	@Override
	public void addComment(Comment comment) {
		if(comment.getId() > 0) {
			System.out.println("This assessment is already exist in memory");
			return;
		}
		comment.setId(maxId++);
		comments.add(Objects.requireNonNull(comment, "This object does not cointains any information"));
	}

	@Override
	public void deleteComment(int id) {
		if(checkArrayIsEmpty()) {
			return;
		}
		Iterator<Comment> iterator = comments.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().getId() == id) {
				iterator.remove();
				return;
			}
		}
	}

	@Override
	public void deleteComments(Person user) {
		if(checkArrayIsEmpty()) {
			return;
		}
		Iterator<Comment> iterator = comments.iterator();
		while (iterator.hasNext()) {
			Comment comment = (Comment) iterator.next();
			if(comment.getCreatedBy().equals(user)) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteComments(Establishment establishment) {
		if(checkArrayIsEmpty()) {
			return;
		}
		Iterator<Comment> iterator = comments.iterator();
		while (iterator.hasNext()) {
			Comment comment = (Comment) iterator.next();
			if(comment.checkEstablishment(establishment)) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteComments(Establishment establishment, Person user) {
		if(checkArrayIsEmpty()) {
			return;
		}
		Iterator<Comment> iterator = comments.iterator();
		while (iterator.hasNext()) {
			Comment comment = (Comment) iterator.next();
			if(comment.checkEstablishment(establishment) && comment.getCreatedBy().equals(user)) {
				iterator.remove();
			}
		}
	}

	@Override
	public Comment getComment(int id) {
		if(checkArrayIsEmpty()) {
			return null;
		}
		for(Comment comment: comments) {
			if(comment.getId() == id) {
				return comment;
			}
		}
		return null;
	}

	@Override
	public List<Comment> getComments(Person user) {
		if(checkArrayIsEmpty()) {
			return null;
		}
		List<Comment> commentsGet = new ArrayList<>(); 
		for(Comment comment: comments) {
			if(comment.getCreatedBy().equals(user)) {
				commentsGet.add(comment);
			}
		}
		return commentsGet;
	}

	@Override
	public List<Comment> getComments(Establishment establishment) {
		if(checkArrayIsEmpty()) {
			return null;
		}
		List<Comment> commentsGet = new ArrayList<>(); 
		for(Comment comment: comments) {
			if(comment.checkEstablishment(establishment)) {
				commentsGet.add(comment);
			}
		}
		return commentsGet;
	}

	@Override
	public List<Comment> getComments(Establishment establishment, Person user) {
		if(checkArrayIsEmpty()) {
			return null;
		}
		List<Comment> commentsGet = new ArrayList<>(); 
		for(Comment comment: comments) {
			if(comment.checkEstablishment(establishment) && comment.getCreatedBy().equals(user)) {
				commentsGet.add(comment);
			}
		}
		return commentsGet;
	}
	
	public boolean checkArrayIsEmpty() {
		if(comments.isEmpty()) {
			System.out.println("Comment array is empty");
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> getComments() {
		if(!checkArrayIsEmpty()) {
			return null;
		}
		return comments;
	}
}
