package com.eteration.simplebanking.mapper;

import java.util.Optional;

import com.eteration.simplebanking.entity.AccountTransaction;
import com.eteration.simplebanking.model.AccountTransactionDTO;
import com.eteration.simplebanking.model.Transaction;

public class TransactionMapper {

    public static Transaction toTransactionDTO(AccountTransaction accountTransaction) {
        if (!Optional.ofNullable(accountTransaction).isPresent()) {
            return null;
        }
        return new AccountTransactionDTO(accountTransaction.getType(),accountTransaction.getDate(),accountTransaction.getAmount(),accountTransaction.getApprovalCode()) ;
    }
    
    
}
