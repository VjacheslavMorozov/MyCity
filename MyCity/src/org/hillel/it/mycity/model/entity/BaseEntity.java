package org.hillel.it.mycity.model.entity;

import java.util.Date;

public abstract class BaseEntity {
	private int id;
	private Date createdDate;
	private Date modifiedDate;
	private Person createdBy;
	private Person modifiedBy;
	private static int idCount = 1;
	
	public BaseEntity(Person person){
		setId();
		setCreateDate(new Date());
		setCreatedBy(person);		
	}
	
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
	protected void setCreatedBy(Person createdBy){
		this.createdBy = createdBy;
	}
	
	public Person getCreatedBy(){
		return createdBy;
	}
	
	public void setModifiedBy(Person modifiedBy){
		this.modifiedBy = modifiedBy;
	}
	
	public Person getModifiedBy(){
		return modifiedBy;
	}
	
	protected void setId() {
		id = idCount;
		idCount++;
	}
	
	public int getId() {
		return id;
	}
	
	public int getIdCount() {
		return idCount;
	}
}
