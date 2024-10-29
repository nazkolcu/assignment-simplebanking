package com.eteration.simplebanking.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AccountTransaction {

    @Id
    private Long id;
	public String type;
	public Instant date;
	public double amount;
	public UUID approvalCode;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountNumber")
    private Account account;
    
    public AccountTransaction(String transactionType, Instant date,double amount, Account account) {
        this.amount = amount;
        this.type = transactionType;
        this.date=date;
        this.account = account;
    }
    
    public AccountTransaction() {
    }
    
	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String transactionType) {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

	public UUID getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(UUID approvalCode) {
		this.approvalCode = approvalCode;
	}

}
