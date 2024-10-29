package com.eteration.simplebanking.model;

import java.time.Instant;
import java.util.UUID;

public class AccountTransactionDTO extends Transaction {
	
	//for Task 2
	public AccountTransactionDTO(String transactionType,Instant date,double amount,UUID approvalCode) {
		super(transactionType,date,amount,approvalCode);
	}

	//Never used just mapping
	@Override
	public double post(double balance) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}


