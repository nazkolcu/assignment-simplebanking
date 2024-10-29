package com.eteration.simplebanking.model;


public class BillPaymentTransaction extends Transaction {
	
	private String payee;
	
	public BillPaymentTransaction(String companyName,double amount) {
		super(amount);
		this.payee=companyName;
		this.type="payment";
	}
	
	@Override
	public double post(double balance) throws InsufficientBalanceException{
		return withdraw(balance);
	}

	public String getCompanyName() {
		return payee;
	}

	public void setCompanyName(String companyName) {
		this.payee = companyName;
	}
	
	@Override
	public String toString() {
		String billPayment = "payee : "+ payee + super.toString();
		System.out.println(billPayment);
		return billPayment;
	}
}


