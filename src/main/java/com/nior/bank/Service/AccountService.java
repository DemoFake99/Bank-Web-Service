package com.nior.bank.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nior.bank.Model.Account;
import com.nior.bank.Repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
	
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAccountsByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    public void transferFunds(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) {
        Account sourceAccount = accountRepository.findByAccountNumber(sourceAccountNumber);
        Account targetAccount = accountRepository.findByAccountNumber(targetAccountNumber);

        if (sourceAccount == null || targetAccount == null) {
            throw new IllegalArgumentException("One or both accounts not found.");
        }

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds in the source account.");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        accountRepository.save(sourceAccount);

        targetAccount.setBalance(targetAccount.getBalance().add(amount));
        accountRepository.save(targetAccount);
    }
}