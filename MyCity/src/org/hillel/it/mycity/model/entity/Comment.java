package org.hillel.it.mycity.model.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comment {
	/*Есть два вариант, либо сделать Commet, как класс, который создается единажды для каждого заведения 
	*или как класс для каждого комментария, в первом случае у меня возникла проблема из-за того, что
	* у одного комменты может быть несколько оценок commentAssessment. Идеально для этого был бы 2мерный
	* массив*/
	private int commentAssessment;
	private Map<Integer,Integer> ids;
	private List<String> comments;
	Comment(){
		comments = new ArrayList<>();
		ids = new HashMap<>();
		commentAssessment = 0;
	}
	public void setComment(String comment){
		
		this.comments.add(comment);
		
	}
	public List<String> getCommentsForEstablisment(){
		
		return comments;
		
	}
	public void setCommentPositiveAssessment(String comment){
		
		++commentAssessment;
		int index = comments.indexOf(comment);
		ids.put(index, commentAssessment);
		
	}
	public void setCommentNegativeAssessment(String comment){
		
		--commentAssessment;
		int index = comments.indexOf(comment);
		ids.put(index, commentAssessment);
		
	}
	public int getCommentAssessment(String comment){
		
		int index = comments.indexOf(comment);
		return ids.get(index);
		
	}
}
