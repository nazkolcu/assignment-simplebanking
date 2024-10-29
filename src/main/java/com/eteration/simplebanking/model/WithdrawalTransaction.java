package com.eteration.simplebanking.model;

import java.time.Instant;
import java.util.UUID;

public class WithdrawalTransaction extends Transaction {
	
	public WithdrawalTransaction(double amount) {
		super(amount);
		this.type = "withdrawal";
	}
	
	//for Task 2
	public WithdrawalTransaction(String transactionType,Instant date,double amount,UUID approvalCode) {
		super(transactionType,date,amount,approvalCode);
	}
	
	@Override
	public double  post(double balance) throws InsufficientBalanceException {
		return withdraw(balance);	
	}
	
}


