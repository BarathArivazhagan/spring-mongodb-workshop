package com.barath.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	private Logger logger=LoggerFactory.getLogger(ApplicationControllerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex){
		
		logger.error(ex.getMessage());
		ex.printStackTrace();
		
		return ex.getMessage();
	}

}
