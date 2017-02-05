package com.barath.app;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

@Repository
public class DepartmentRepository implements BasicDocumentConverter<Department>{
	
	private static final Logger logger=LoggerFactory.getLogger(DepartmentRepository.class);
	private MongoCollection<Document> collection;
	private static final String DEPARTMENT_ID="DEPARTMENT_ID";
	private static final String DEPARTMENT_NAME="DEPARTMENT_NAME";
	
	public DepartmentRepository() {
		this.collection=MongoClientFactory.getMongoCollection(MongoDBConstants.MONGODB_DATABASE_NAME, MongoDBConstants.DEPARTMENT_COLLECTION);
	}
	
	public Department addDepartment(Department department){
		
		
		  
		return department;
		
	}
	
	public Department getDepartment(long departmentId){
		
		
		return null;
	}
	
	public Department updateDepartment(Department department){
		
		
		return null;
	}
	
	public Department deleteDepartment(long departmentId){
		
		
		return null;
	}

	public MongoCollection<Document> getDepartmentCollection() {
		return departmentCollection;
	}

	public void setDepartmentCollection(MongoCollection<Document> departmentCollection) {
		this.departmentCollection = departmentCollection;
	}
	
	
	public Document toDocument(Department department){
		
		Document document=new Document(DEPARTMENT_ID,department.getDepartmentId());
		document.append(DEPARTMENT_NAME, department.getDepartmentName());
		return document;
	}
	
	

	@Override
	public Department toObject(Document document) {
		Department department=new Department(document.getLong(DEPARTMENT_ID), document.getString(DEPARTMENT_NAME));
		return department;
	}

	
	


}
