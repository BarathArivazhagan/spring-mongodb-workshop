package com.barath.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	
	
	private static final Logger logger=LoggerFactory.getLogger(CompanyService.class);
	
	private CompanyRepository companyRepository;
	
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository=companyRepository;
	}
	
	
	public Company addCompany(Company company){
		
		
		return null;
	}
	
	public Company getCompany(long companyId){
		
		
		return null;
	}
	
	public Company updateCompany(Company company){
		
		
		return null;
	}
	
	public Company deleteCompany(long companyId){
		
		
		return null;
	}
	
	

}
