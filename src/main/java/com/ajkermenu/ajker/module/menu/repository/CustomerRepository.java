package com.ajkermenu.ajker.module.menu.repository;

import com.ajkermenu.ajker.module.menu.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

    Customer findByCustomerId(String customerId);
}
