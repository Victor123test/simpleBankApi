package com.labsit.codetest.enums;

public enum TransactionType {

	DEPOSIT("Deposit"),

	WITHDRAW("withdraw");

	private String type;

	private TransactionType(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
