package com.nior.bank.Model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private Long accountId;
    private Long customerId;
    private String accountNumber;
    private BigDecimal balance;
    private String accountType;
    private boolean isActive;
}