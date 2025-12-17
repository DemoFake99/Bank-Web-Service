package com.nior.bank.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nior.bank.Model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findByCustomerId(Long customerId);

    Account findByAccountNumber(String accountNumber);
}
