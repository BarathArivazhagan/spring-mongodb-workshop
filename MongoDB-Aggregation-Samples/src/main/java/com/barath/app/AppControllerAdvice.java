package com.barath.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvice {
	
	private static final Logger logger=LoggerFactory.getLogger(AppControllerAdvice.class);
	
	
	@ExceptionHandler(Exception.class)
	public String handleAppExceptions(Exception ex){
		logger.error("Exception in APP "+ex.getMessage());
		return ex.getMessage();
	}

}
