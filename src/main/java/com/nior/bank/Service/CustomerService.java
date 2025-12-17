package com.nior.bank.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nior.bank.Model.Customer;
import com.nior.bank.Repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CRUD operations
    public Customer createCustomer(Customer customer) {
        // Business logic: e.g., validation, checking for existing email
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // More complex logic: e.g., update customer details
    public Customer updateCustomer(Customer customer) {
        // Find existing customer, check data, then save
        return customerRepository.save(customer);
    }
}
