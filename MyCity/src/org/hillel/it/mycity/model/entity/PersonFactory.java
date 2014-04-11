package org.hillel.it.mycity.model.entity;

public class PersonFactory {
	
	public static Person getPerson(Group group){
		switch (group) {
		
		case Administrator:
			return new Administrator();
			
		case Moderator:
			return new Moderator();
			
		case User:
			return new User();
			
		default:
			return null;
				
		}
		
	}

}
