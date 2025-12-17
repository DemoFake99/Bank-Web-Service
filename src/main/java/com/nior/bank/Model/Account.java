package com.nior.bank.Model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	private Long accountId;

	@JsonProperty("customer_id")
	private Long customerId;

	@JsonProperty("account_number")
	private String accountNumber;

	@JsonProperty("balance")
	private BigDecimal balance;

	@JsonProperty("account_type")
	private String accountType;

	@JsonProperty("is_active")
	private boolean isActive;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal subtract) {
		this.balance = subtract;
	}
}