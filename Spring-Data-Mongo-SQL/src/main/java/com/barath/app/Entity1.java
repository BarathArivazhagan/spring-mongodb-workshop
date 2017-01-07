package com.barath.app;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ENTITY1")
public class Entity1 implements Serializable{
	
	
	@Id
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Entity1(long id) {
		super();
		this.id = id;
	}

	public Entity1() {
		super();
		
	}
	
	
	
	
	
	

}
