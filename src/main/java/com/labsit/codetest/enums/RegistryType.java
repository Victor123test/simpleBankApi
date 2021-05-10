package com.labsit.codetest.enums;

public enum RegistryType {
	
	CNPJ("CNPJ"),
	CPF("CPF");
	
	private String type;
	
	private RegistryType(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
