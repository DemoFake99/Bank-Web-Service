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
        // Business logic: e.g., generate unique account number, initial deposit validation
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAccountsByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    /**
     * Handles the funds transfer between two accounts.
     * @param sourceAccountNumber Account to debit
     * @param targetAccountNumber Account to credit
     * @param amount The amount to transfer
     */
    @Transactional // Ensures atomicity: BOTH operations must succeed or BOTH fail
    public void transferFunds(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) {
        Account sourceAccount = accountRepository.findByAccountNumber(sourceAccountNumber);
        Account targetAccount = accountRepository.findByAccountNumber(targetAccountNumber);

        if (sourceAccount == null || targetAccount == null) {
            throw new IllegalArgumentException("One or both accounts not found.");
        }

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds in the source account.");
        }

        // 1. Debit the source account
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        accountRepository.save(sourceAccount);

        // 2. Credit the target account
        targetAccount.setBalance(targetAccount.getBalance().add(amount));
        accountRepository.save(targetAccount);

        // A separate Transaction model/logic would normally record this for history
    }
}