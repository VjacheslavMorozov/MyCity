package org.hillel.it.mycity.model.entity;

import java.util.Date;

public abstract class BaseEntity {
	private int id;
	private Date createdDate;
	private Date modifiedDate;
	private Administrator createdBy;
	private Administrator modifiedBy;
	private static int idCount = 1;
	
	protected void setCreateDate(Date createdDate){
		
		this.createdDate = createdDate;
		
	}
	public Date getCreatedDate(){
		
		return createdDate;
		
	}
	public void setModifiedDate(Date modifiedDate){
		
		this.modifiedDate = modifiedDate;
		
	}
	public Date getModifiedDate(){
		
		return modifiedDate;
		
	}
	protected void setCreatedBy(Administrator createdBy){
		
		this.createdBy = createdBy;
		
	}
	public Administrator getCreatedBy(){
		
		return createdBy;
		
	}
	public void setModifiedBy(Administrator modifiedBy){
		
		this.modifiedBy = modifiedBy;
		
	}
	public Administrator getModifiedBy(){
		
		return modifiedBy;
		
	}
	public void setId() {
		
		id = idCount;
		idCount++;
		
	}
	public int getId() {
		
		return id;
		
	}
	
}
