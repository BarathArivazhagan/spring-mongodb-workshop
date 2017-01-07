package com.barath.app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EntityService {
	
	@Autowired
	private Entity1Repository entity1Rep;
	
	@Autowired
	private Entity2Repository entity2Rep;
	
	
	
	
	@PostConstruct
	public void init(){
		Entity1 en1=new Entity1(100);
		en1=entity1Rep.save(en1);
		Entity2 en2=new Entity2(1000,en1.getId());
		entity2Rep.save(en2);
		
	}

}
