package com.barath.app;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class EmployeeRepository  implements BasicDocumentConverter<Employee>{
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeeRepository.class);
	private MongoCollection<Document> collection;
	private static final String EMPLOYEE_ID="EMPLOYEE_ID";
	private static final String EMPLOYEE_NAME="EMPLOYEE_NAME";
	private static final String EMPLOYEE_AGE="EMPLOYEE_AGE";
	private static final String EMPLOYEE_GENDER="EMPLOYEE_GENDER";
	private static final String EMPLOYEE_SALARY="EMPLOYEE_SALARY";
	private static final String COMPANY_ID="COMPANY_ID";
	private static final String DEPARTMENT_ID="DEPARTMENT_ID";
	
	
	public EmployeeRepository() {
		this.collection=MongoClientFactory.getMongoCollection(MongoDBConstants.MONGODB_DATABASE_NAME, MongoDBConstants.EMPLOYEE_COLLECTION);
	}
	public Employee addEmployee(Employee employee){	
		
		getCollection().insertOne(toDocument(employee));
		return employee;
	}
	
	public Employee getEmployee(long employeeId){
		
		Employee employee=null;
		FindIterable<Document> document=getCollection().find(new Document(EMPLOYEE_ID, employeeId));
		if(document !=null ){
			employee=toObject(document.first());
		}
		return employee;
	}
	
	public Employee updateEmployee(Employee employee){
		
		getCollection().findOneAndUpdate(new Document(EMPLOYEE_ID,employee.getEmployeeId()), toDocument(employee));
		return employee;
	}
	
	public void deleteEmployee(long employeeId){
		getCollection().findOneAndDelete(new Document(EMPLOYEE_ID, employeeId));
	}
	
	
	@Override
	public Document toDocument(Employee employee) {		 		
		Document document=new Document(JSONUtils.toMap(employee));		
		return document;
	}
	
	
	@Override
	public Employee toObject(Document document) {
		Employee employee=new Employee(document.getLong(EMPLOYEE_ID),
				document.getString(EMPLOYEE_NAME),
				document.getInteger(EMPLOYEE_AGE),
				document.get(EMPLOYEE_GENDER),
				document.get(key)
		return null;
	}
	
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}
	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}
	
}
