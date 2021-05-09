package com.labsit.codetest.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.labsit.codetest.model.CheckingAccount;
import com.labsit.codetest.model.Client;
import com.labsit.codetest.services.CheckingAccountService;

public class ClientValidator {
	
	@Autowired
	private CheckingAccountService checkingAccountService;

	public void validate(Client client) throws Exception {

		if (client == null)
			throw new Exception("Client cant be null");

		if (client.getRegistryNumber() == null)
			throw new Exception("Client registry number can't be empty");

		if (client.getRegistryType() == null)
			throw new Exception("Client registry type can't be empty");

		if (client.getAccount().getAccountNumber() == null)
			throw new Exception("Client account number can't be empty");
		
		CheckingAccount chAcc = checkingAccountService.findByNumber(client.getAccount().getAccountNumber());
		
		if (chAcc != null)
			throw new Exception("Account number already used can't be empty");
		
		if (client.getAccount().getAgency() == null)
			throw new Exception("Agency number can't be empty");
	}

}
