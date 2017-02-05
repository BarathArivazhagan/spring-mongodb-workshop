package com.barath.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

@Configuration
public class MongoDBConfiguration {
	
	@Value("${mongodb.host}")
	private String mongoHost;
	
	@Value("${mongodb.port}")
	private int mongoPort;
	
	@Bean
	public MongoClientOptions mongoClientOptions(){
		
		MongoClientOptions mongoClientOptions= MongoClientOptions.builder().build();
		return mongoClientOptions;
	}
	
	
	@Bean
	public MongoClient mongoClient(MongoClientOptions mongoClientOptions){		
		MongoClient mongoClient=new MongoClient(mongoHost, mongoPort);
		
		return mongoClient;		
		
	}

}
