package org.hillel.it.mycity.model.entity;

import java.util.Date;

public abstract class BaseEntity {
	private int id;
	private Date createdDate;
	private Date modifiedDate;
	private Person createdBy;
	private Person modifiedBy;
	private int maxId;

	public BaseEntity(){
		setCreateDate(new Date());	
	}
	
	private void setCreateDate(Date createdDate){
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
	
	public void setCreatedBy(Person createdBy){
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setMaxId(int maxId) {
		this.maxId = maxId;
	}
	
	public void checkId(int id) {
		if(id < 1 || maxId < id) {
			throw new RuntimeException("Incorrect id");
		}
	}
}
