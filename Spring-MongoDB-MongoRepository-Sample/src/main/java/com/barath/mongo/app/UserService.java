package com.barath.mongo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
	
	private UserRepository userRep; 
	
	
	@Autowired
	public UserService(UserRepository userRep){
		this.userRep=userRep;
	}
	
	public void addUser(User user){
		userRep.save(user);
	}
	
	public User getUser(long userId){
		User user=null;
		if(userRep.exists(userId)){
			user=userRep.findByUserId(userId);
		}
		
		return user;
	}

	public void updateUser(User user){
		if(isUserExists(user)){
			User userToBeUpdated=getUser(user.getUserId());
			userToBeUpdated.setUserId(user.getUserId());
			userToBeUpdated.setUserName(user.getUserName());
			userRep.save(user);
			
		}
	}
	public void deleteUser(long userId){
		if(isUserExists(userId)){
			userRep.delete(userId) ;
		}
	}
	public void deleteUser(User user){
		if(isUserExists(user)){
			userRep.delete(user) ;
		}
	}
	
	public boolean isUserExists(long userId){
		return userRep.findByUserId(userId) !=null ?  true :  false;
	}
	
	public boolean isUserExists(User user){
		if(user != null){
			return userRep.findByUserId(user.getUserId()) !=null ?  true :  false;
			
		}
		return false;
	}

	public User getUser(String userName) {
		
		return userRep.findByUserName(userName);
	}

	public List<User> findAllUsers() {
		return userRep.findAll();
	}

	

}
