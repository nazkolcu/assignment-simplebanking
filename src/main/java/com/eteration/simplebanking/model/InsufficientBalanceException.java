package com.eteration.simplebanking.model;


public class InsufficientBalanceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException() {
		super("Insufficient Balance");
	}
	
	public InsufficientBalanceException(double amount) {
		super("Insufficient Balance for" + amount);
	}
}
