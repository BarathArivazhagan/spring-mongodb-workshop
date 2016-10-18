package com.barath.mongo.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringMongoDbMongoRepositorySampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoDbMongoRepositorySampleApplication.class, args);
	}
	
	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Adding some arbitary users to collection ");
		User user1=new User(100, "BARATH");
		User user2=new User(101, "SACHIN");
		Arrays.asList(user1,user2).stream().forEach(userService::addUser);
		
		
	}
	
	
	
}
