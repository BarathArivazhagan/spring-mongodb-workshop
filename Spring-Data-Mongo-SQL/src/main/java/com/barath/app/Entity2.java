package com.barath.app;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="test")
public class Entity2  implements Serializable{
	
	@org.springframework.data.annotation.Id
	private long Id;
	
	
	@Field("Entity1REF")
	private long entity1Id;
	

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Entity2() {
		super();
		
	}

	public Entity2(long id) {
		super();
		Id = id;
	}

	public long getEntity1Id() {
		return entity1Id;
	}

	public void setEntity1Id(long entity1Id) {
		this.entity1Id = entity1Id;
	}

	public Entity2(long id, long entity1Id) {
		super();
		Id = id;
		this.entity1Id = entity1Id;
	}
	
	
	
	

}
