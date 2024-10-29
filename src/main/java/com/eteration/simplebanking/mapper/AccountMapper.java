package com.eteration.simplebanking.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.eteration.simplebanking.entity.Account;
import com.eteration.simplebanking.entity.AccountTransaction;
import com.eteration.simplebanking.model.BankAccount;
import com.eteration.simplebanking.model.Transaction;

public class AccountMapper {

    public static BankAccount toDTO(Account account) {
        if (!Optional.ofNullable(account).isPresent()) {
            return null;
        }
        return new BankAccount(account.getOwner(), account.getAccountNumber(), account.getBalance(),toTransactionListDTO(account.getAccountTransactions()) );
    }
    
    public static Account toEntity(BankAccount account) {
        if (!Optional.ofNullable(account).isPresent()) {
            return null;
        }
        return new Account(account.getOwner(), account.getAccountNumber(), account.getBalance());
    }
    
    private static List<Transaction> toTransactionListDTO(List<AccountTransaction> accountTransactionList){
    	List<Transaction> transactionList = new ArrayList<Transaction>();
    	if(!accountTransactionList.isEmpty()) {
    		transactionList = accountTransactionList.stream().map(TransactionMapper::toTransactionDTO).collect(Collectors.toList());
    	}
    	return transactionList;
    	
    }
    
}
