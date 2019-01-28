package com.barath.app;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.MongoCollection;

public class CompanyRepository  implements BasicDocumentConverter<Company>{
	
	private static final Logger logger=LoggerFactory.getLogger(CompanyRepository.class);
	private MongoCollection<Document> collection;
	private static final String COMPANY_ID="COMPANY_ID";
	private static final String COMPANY_NAME="COMPANY_NAME";
	
	
	
	public CompanyRepository() {
		this.collection=MongoClientFactory.getMongoCollection(MongoDBConstants.MONGODB_DATABASE_NAME, MongoDBConstants.COMPANY_COLLECTION);
	}
	public Company addCompany(Company company){
		
		
		return null;
	}
	
	public Company getCompany(long companyId){
		
		
		return null;
	}
	
	public Company updateCompany(Company company){
		
		
		return null;
	}
	
	public Company deleteCompany(long companyId){
		
		
		return null;
	}
	@Override
	public Document toDocument(Company company) {
		Document document=new Document(COMPANY_ID,company.getCompanyId());
		document.append(COMPANY_NAME, company.getCompanyName());
		return document;
	}
	@Override
	public Company toObject(Document document) {
		Company company=new Company(document.getLong(COMPANY_ID), document.getString(COMPANY_NAME));
		return company;
	}
	public MongoCollection<Document> getCollection() {
		return collection;
	}
	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}
	
	
	

}
