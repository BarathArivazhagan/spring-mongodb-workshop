package com.barath.mongo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AppController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String handleHome(){
		return "Welcome to User Application";
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@RequestBody User user){
		if(user !=null){
			userService.addUser(user);
			return "User is added successfully";
		}
		return "User is not  added successfully. Check the logs for error ";
	}
	
	
	@RequestMapping("/getUser")
	public User getUser(@RequestParam("id") long userId){
		
		return userService.getUser(userId);
	}
	
	@RequestMapping("/getUserByName")
	public User getUser(@RequestParam("name") String userName){
		return userService.getUser(userName);
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@RequestBody User user){
		if(user !=null ){
			userService.updateUser(user);
		}
		return "User is successfully updated";
	}
	
	@RequestMapping("/findAll")
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleeError(Exception ex){
		return ex.getMessage();
	}
	
	

}
