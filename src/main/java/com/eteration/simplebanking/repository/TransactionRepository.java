package com.eteration.simplebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eteration.simplebanking.entity.AccountTransaction;

public interface TransactionRepository  extends JpaRepository<AccountTransaction, Long>{
}
