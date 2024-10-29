package com.eteration.simplebanking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class BankAccount {

	
	private String owner;
	private String accountNumber;
	private double balance;
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	public BankAccount(String owner,String accountNo) {
		this.owner=owner;
		this.accountNumber=accountNo;
		this.balance=0;		
	}
	
	//For Task 2
	public BankAccount(String owner,String accountNo,double balance,List<Transaction> transactions) {
		this.owner=owner;
		this.accountNumber=accountNo;
		this.balance=balance;		
		this.transactions=transactions;
	}
	
	public void post(Transaction transaction) throws InsufficientBalanceException {
		this.balance =  transaction.post(this.balance);
		transactions.add(transaction);
		
	}
	
	//For Task 2
	public UUID postWithUUID(Transaction transaction) throws InsufficientBalanceException {
		this.balance =  transaction.post(this.balance);
		transactions.add(transaction);
		return UUID.randomUUID();
		
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNo) {
		this.accountNumber = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
