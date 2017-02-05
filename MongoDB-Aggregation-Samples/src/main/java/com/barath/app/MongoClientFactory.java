package com.barath.app;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Component
public class MongoClientFactory {
	
	
	private static MongoClientFactory mongoClientFactory;
	private MongoClient mongoClient;
	private Map<String,MongoCollection<Document>> mongoCollections=new ConcurrentHashMap<String,MongoCollection<Document>>(5);
	
	public MongoClientFactory(MongoClient mongoClient) {
		this.mongoClient=mongoClient;
	}
	
	public MongoClientFactory() {
		
	}
	
	public static MongoClientFactory getInstance(){
		if(mongoClientFactory ==null){
			mongoClientFactory=new MongoClientFactory();
		}
		return mongoClientFactory;
		
	}
	
	public static MongoDatabase getMongoDataBase(String databaseName){
		
		return getMongoClient().getDatabase(databaseName);
	}
	
	public static MongoCollection<Document> getMongoCollection(String databaseName,String collectionName){
		MongoCollection<Document> mongoCollection=null;
		if(getInstance().getMongoCollections().containsKey(collectionName)){
			mongoCollection=getInstance().getMongoCollections().get(collectionName);
		}
		else{
			mongoCollection=getMongoDataBase(databaseName).getCollection(collectionName);
			getInstance().getMongoCollections().put(collectionName, mongoCollection);
		}
		
		return mongoCollection;
	}
	
	public static MongoClient getMongoClient(){
		return getInstance().getMongoClientBean();
	}
	
	public MongoClient getMongoClientBean(){
		return this.mongoClient;
	}
	
	

	
	public Map<String, MongoCollection<Document>> getMongoCollections() {
		return mongoCollections;
	}

	public void setMongoCollections(Map<String, MongoCollection<Document>> mongoCollections) {
		this.mongoCollections = mongoCollections;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	
	

}
