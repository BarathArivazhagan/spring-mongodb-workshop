package com.barath.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration	
public class MongoDBConnection {
	
	@Bean
	MongoClient mongoClient(){
		MongoClient mongoClient=new MongoClient("localhost", 27017);
		
		return mongoClient;
	}
	

}
