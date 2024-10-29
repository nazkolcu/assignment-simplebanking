package com.eteration.simplebanking.controller;

import java.util.UUID;


public class TransactionStatus {
	
	private String status;
	private UUID approvalCode;
	
	public TransactionStatus(UUID approvalCode) {
		this.status="OK";
		this.approvalCode=approvalCode;
	}
	
	public TransactionStatus(boolean isError) {
		this.status="NOK";
		this.approvalCode=UUID.randomUUID();
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UUID getApprovalCode() {
		return approvalCode;
	}
	public void setApprovalCode(UUID approvalCode) {
		this.approvalCode = approvalCode;
	}

}
