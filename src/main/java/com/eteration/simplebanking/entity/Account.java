package com.eteration.simplebanking.entity;

import java.util.List;

import com.eteration.simplebanking.model.Transaction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account {

    @Id
    private Long id;
    private String owner;
    private String accountNumber;
    private double balance;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountTransaction> transactions;
    
    
	//For Task 2
	public Account(String owner,String accountNo,double balance) {
		this.owner=owner;
		this.accountNumber=accountNo;
		this.balance=balance;		
	}
	
	public Long getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
    public List<AccountTransaction> getAccountTransactions() {
        return transactions;
    }

    public void setAccountTransactions(List<AccountTransaction> transactions) {
        this.transactions = transactions;
    }
}
