package org.hillel.it.mycity.persistence.repository.inmemory;

import java.util.ArrayList;
import java.util.Collections;
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
		if(!validComment(comment)) {
			throw new RuntimeException("This assessment is already exist in memory");
		}
		comment.setId(maxId++);
		comments.add(Objects.requireNonNull(comment, "This object does not cointains any information"));
	}
	
	public boolean validComment(Comment comment) {
		if(comment.getId() > 0) {
			return false;
		}
		return true;
	}

	@Override
	public void deleteComment(int id) {
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
		Iterator<Comment> iterator = comments.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().getCreatedBy().equals(user)) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteComments(Establishment establishment) {
		Iterator<Comment> iterator = comments.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().checkEstablishment(establishment)) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteComments(Establishment establishment, Person user) {
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
		try {
			commentsNotNull();
		} catch (NullPointerException e) {
			throw new NullPointerException("Array list is empty");
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
		try {
			commentsNotNull();
		} catch (NullPointerException e) {
			throw new NullPointerException("Array list is empty");
		}
		List<Comment> comments = new ArrayList<>(); 
		for(Comment comment: this.comments) {
			if(comment.getCreatedBy().equals(user)) {
				comments.add(comment);
			}
		}
		return Collections.unmodifiableList(comments);
	}

	@Override
	public List<Comment> getComments(Establishment establishment) {
		try {
			commentsNotNull();
		} catch (NullPointerException e) {
			throw new NullPointerException();
		}
		List<Comment> comments = new ArrayList<>(); 
		for(Comment comment: this.comments) {
			if(comment.checkEstablishment(establishment)) {
				comments.add(comment);
			}
		}
		return Collections.unmodifiableList(comments);
	}

	@Override
	public List<Comment> getComments(Establishment establishment, Person user) {
		try {
			commentsNotNull();
		} catch (NullPointerException e) {
			throw new NullPointerException();
		}
		List<Comment> comments = new ArrayList<>(); 
		for(Comment comment: this.comments) {
			if(comment.checkEstablishment(establishment) && comment.getCreatedBy().equals(user)) {
				comments.add(comment);
			}
		}
		return Collections.unmodifiableList(comments);
	}

	@Override
	public List<Comment> getComments() {
		return Collections.unmodifiableList(comments);
	}
	
	private void commentsNotNull() {
		if(comments.isEmpty()) {
			throw new NullPointerException("Comments array is empty");
		}
	}
}
