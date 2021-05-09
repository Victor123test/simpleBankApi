package com.labsit.codetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.labsit.codetest.enums.RegistryType;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@OneToOne
	private CheckingAccount account;

	private RegistryType registryType;

	private String registryNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistryNumber() {
		return registryNumber;
	}

	public void setRegistryNumber(String registryNumber) {
		this.registryNumber = registryNumber;
	}

	public RegistryType getRegistryType() {
		return registryType;
	}

	public void setRegistryType(RegistryType registryType) {
		this.registryType = registryType;
	}

	public CheckingAccount getAccount() {
		return account;
	}

	public void setAccount(CheckingAccount account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
