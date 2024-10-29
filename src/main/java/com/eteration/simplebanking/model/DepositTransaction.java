package com.eteration.simplebanking.model;

import java.time.Instant;
import java.util.UUID;

// This class is a place holder you can change the complete implementation
public class DepositTransaction extends Transaction {

	public DepositTransaction(double amount) {
		super(amount);
		this.type = "deposit";
	}
	
	//for Task 2
	public DepositTransaction(String transactionType,Instant date,double amount,UUID approvalCode) {
		super(transactionType,date,amount,approvalCode);
	}

	@Override
	public double post(double balance) {
		return deposit(balance);
	}

}
