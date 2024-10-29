package com.eteration.simplebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.simplebanking.model.BankAccount;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;

@RestController
@RequestMapping("/account/v1")
public class AccountController {

	@Autowired
	private AccountService accountService; 
	
	@GetMapping("/{accountNumber}")
    public ResponseEntity<BankAccount> getAccount(String accountNumber) {
		BankAccount account = accountService.getAccount(accountNumber);
	    return new ResponseEntity<>(account, HttpStatus.OK);
    }
	
   
    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(String accountNumber,@RequestBody DepositTransaction amountRequest) throws InsufficientBalanceException {
    	TransactionStatus transactionStatus= accountService.credit(accountNumber,amountRequest);
        return new ResponseEntity<>(transactionStatus, HttpStatus.OK);
    }
    
    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(String accountNumber,@RequestBody WithdrawalTransaction amountRequest) throws InsufficientBalanceException {
    	TransactionStatus transactionStatus=  accountService.debit(accountNumber,amountRequest);
    	 return new ResponseEntity<>(transactionStatus, HttpStatus.OK);
	}
}