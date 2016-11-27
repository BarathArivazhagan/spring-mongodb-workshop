package com.barath.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	
	
	@GetMapping("/")
	public String home(){
		return "welcome to MongoDB application";
	}
	
	@GetMapping("/add/team")
	public String add(){
		return "welcome to MongoDB application";
	}

}
