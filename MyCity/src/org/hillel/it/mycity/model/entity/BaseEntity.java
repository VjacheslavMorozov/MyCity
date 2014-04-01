package org.hillel.it.mycity.model.entity;

import java.util.Date;

public abstract class BaseEntity {
	private int id = 0;
	private Date createdDate;
	private Date modifiedDate;
	private Administrator createdBy;
	private Administrator modifiedBy;
	
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
	public int getId(){
		
		return id;
		
	}
	protected void setId(){
		
		id++;
		
	}
}
