package com.eteration.simplebanking.model;

import java.time.Instant;
import java.util.UUID;

public abstract class Transaction {
		
	public String type;
	public Instant date;
	public double amount;
	//for Task 2
	public UUID approvalCode;
	
	public Transaction(double amount) {
		this.amount=amount;
		date=Instant.now();
	}
	
	//for Task 2
	public Transaction(String transactionType,Instant date,double amount,UUID approvalCode) {
		this.type = transactionType;
		this.date=date;
		this.amount=amount;
		this.approvalCode=approvalCode;
	}
		
	abstract public double post(double balance) throws InsufficientBalanceException;
	
	public double deposit(double balance) {
		balance = balance + amount;
		return balance;
	}
	
	public double withdraw(double balance) throws InsufficientBalanceException {
		if(amount > balance )
			throw new InsufficientBalanceException(balance);
	
		balance = balance - amount;	
		return balance;
	}
	
	@Override
	public String toString() {
		System.out.println("transactionType : " + type + "transactionDate : " + date
				+"amount : "+amount);
		return super.toString();
	}

	public String getTransactionType() {
		return type;
	}

	public void setTransactionType(String transactionType) {
		this.type = transactionType;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
