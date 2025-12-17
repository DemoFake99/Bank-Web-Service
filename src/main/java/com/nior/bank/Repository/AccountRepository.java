package com.nior.bank.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nior.bank.Model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
    // Find all accounts belonging to a specific customer
    List<Account> findByCustomerId(Long customerId);

    // Find an account by its unique number
    Account findByAccountNumber(String accountNumber);
}
