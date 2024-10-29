package com.eteration.simplebanking.services;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.entity.Account;
import com.eteration.simplebanking.entity.AccountTransaction;
import com.eteration.simplebanking.mapper.AccountMapper;
import com.eteration.simplebanking.model.BankAccount;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.TransactionRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	
    public BankAccount findAccount(String accountNumber) {
    	return new BankAccount(accountNumber, accountNumber);
    }
	
    public BankAccount getAccount(String accountNumber) {
    	Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
    	if(account.isPresent()) {
    		return AccountMapper.toDTO(account.get());
    	}
    	else
    		return null;
    }

    public TransactionStatus credit(String accountNumber,Transaction amountRequest) throws InsufficientBalanceException {
    	Optional<Account> accountOpt = accountRepository.findByAccountNumber(accountNumber);
    	if(accountOpt.isPresent()) {
    		Account account = accountOpt.get();
    		BankAccount bankAccount = AccountMapper.toDTO(account);
    		UUID approvalCode = bankAccount.postWithUUID(new DepositTransaction(amountRequest.amount));
    		account.setBalance(bankAccount.getBalance());
    		dbProcess(account, amountRequest.amount, approvalCode);
    		return new TransactionStatus(approvalCode);
    	}
        return new TransactionStatus(true);
    }
    public TransactionStatus debit(String accountNumber,Transaction amountRequest) throws InsufficientBalanceException {
    	Optional<Account> accountOpt = accountRepository.findByAccountNumber(accountNumber);
    	if(accountOpt.isPresent()) {
    		Account account = accountOpt.get();
    		BankAccount bankAccount = AccountMapper.toDTO(account);
    		UUID approvalCode = bankAccount.postWithUUID(new WithdrawalTransaction(amountRequest.amount));
    		account.setBalance(bankAccount.getBalance());
    		dbProcess(account, amountRequest.amount, approvalCode);
    		return new TransactionStatus(approvalCode);
    	}
        return new TransactionStatus(true);
	}
    
    private void dbProcess(Account account,double amount,UUID approvalCode) {
		AccountTransaction accountTransaction = new AccountTransaction();
		accountTransaction.setAccount(account);
		accountTransaction.setAmount(amount);
		accountTransaction.setDate(Instant.now());
		accountTransaction.setApprovalCode(approvalCode);
        transactionRepository.save(accountTransaction);
        accountRepository.save(account);
    }

}
