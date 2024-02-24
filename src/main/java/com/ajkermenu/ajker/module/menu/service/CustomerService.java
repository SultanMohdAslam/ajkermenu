package com.ajkermenu.ajker.module.menu.service;

import com.ajkermenu.ajker.module.menu.model.Customer;
import com.ajkermenu.ajker.module.menu.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer crateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}