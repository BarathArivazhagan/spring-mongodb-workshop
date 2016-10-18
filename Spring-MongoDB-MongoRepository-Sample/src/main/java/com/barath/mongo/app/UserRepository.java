package com.barath.mongo.app;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<User, Long>{
	
	public User findByUserName(String userName);
	
	public User findByUserId(long userId);

}
