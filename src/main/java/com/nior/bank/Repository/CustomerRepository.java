package com.nior.bank.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nior.bank.Model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // You can add custom methods here. Spring Data JDBC will implement them
    // based on the method name convention.
    Customer findByEmail(String email);
    // You'll need to define custom SQL for complex queries if the convention
    // doesn't suffice, using @Query annotation.
}
