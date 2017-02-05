package com.barath.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	private static final Logger logger=LoggerFactory.getLogger(DepartmentService.class);
	
	private DepartmentRepository departmentRepository;
	
	 public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository=departmentRepository;
	}
	
	
	public Department addDepartment(Department department){
		
		
		return null;
	}
	
	public Department getDepartment(long departmentId){
		
		
		return null;
	}
	
	public Department updateDepartment(Department department){
		
		
		return null;
	}
	
	public Department deleteDepartment(long departmentId){
		
		
		return null;
	}


	public DepartmentRepository getDepartmentRepository() {
		return departmentRepository;
	}


	public void setDepartmentRepository(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	
	
	

}
