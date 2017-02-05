package com.barath.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeService {
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeeService.class);
	private EmployeeRepository employeeRepository;
	
	 public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	
	public Employee addEmployee(Employee employee){
		
		
		return null;
	}
	
	public Employee getEmployee(long employeeId){
		
		
		return null;
	}
	
	public Employee updateEmployee(Employee employee){
		
		
		return null;
	}
	
	public Employee deleteEmployee(long employeeId){
		
		
		return null;
	}
	
	
	

}
