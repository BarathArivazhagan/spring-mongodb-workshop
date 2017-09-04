package com.barath.app.repository;


import com.barath.app.document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,Long>{
}
