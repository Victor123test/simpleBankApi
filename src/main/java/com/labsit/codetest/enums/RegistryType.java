package com.labsit.codetest.enums;

public enum RegistryType {
	
	CORPORATION("CORPORATION"),
	INDIVIDUAL("Individual");
	
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
