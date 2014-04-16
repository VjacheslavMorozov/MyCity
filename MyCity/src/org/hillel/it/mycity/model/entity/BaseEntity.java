package org.hillel.it.mycity.model.entity;

import java.util.Date;

public abstract class BaseEntity {
	private int id;
	private Date createdDate;
	private Date modifiedDate;
	private Person createdBy;
	private Person modifiedBy;

	public BaseEntity(){
		setCreateDate(new Date());	
	}
	
	private void setCreateDate(Date createdDate){
		if(checkDataNotNull(this.createdDate)) {
			System.out.println("Created Date is alredy exist. You can not add another one.");
			return;
		}
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
	
	/**
	 * Add createdBy person to the object. Check if this object field createdBy is no empty
	 * @param createdBy
	 */
	protected void setCreatedBy(Person createdBy){
		if(checkDataNotNull(this.createdBy)) {
			throw new RuntimeException("Created by user is alredy exist. You can not add another one.");
		}
		this.createdBy = createdBy;
	}
	
	public Person getCreatedBy(){
		return createdBy;
	}
	
	public void setModifiedBy(Person modifiedBy){
		if(modifiedBy != createdBy && !modifiedBy.inGroup(Group.Administrator)) {
			throw new RuntimeException("This person can not modify information");
		}
		this.modifiedBy = modifiedBy;
	}
	
	protected Person getModifiedBy(){
		return modifiedBy;
	}
	
	public void setId(int id) {
		if(this.id > 0) {
			throw new RuntimeException("This Entity is alredy has an Id");
		}
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	//TODO нужно добавить проверка на maxId из нужного Repository
	public void checkId(int id) {
		if(id < 1) {
			throw new RuntimeException("Incorrect id");
		}
	}
	
	public <T>boolean checkDataNotNull(T t){
		if(t != null) {
			return true;
		}
		return false;
	}
}
