package com.eteration.simplebanking.model;

public class PhoneBillPaymentTransaction extends BillPaymentTransaction {
	
	private String telephoneNo;
	
	public PhoneBillPaymentTransaction(String companyName ,String telephoneNo,double amount) {
		super(companyName,amount);
		this.telephoneNo=telephoneNo;
		
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	
	@Override
	public String toString() {
		String phoneBillPayment = "telephone No : "+ telephoneNo + super.toString();
		System.out.println(phoneBillPayment);
		return phoneBillPayment;
	}

}
