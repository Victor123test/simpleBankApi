package com.labsit.codetest.validators;

import org.springframework.stereotype.Component;

import com.labsit.codetest.model.Client;

@Component
public class ClientValidator {

	public void validate(Client client) throws Exception {

		if (client == null)
			throw new Exception("Client cant be null");

		if (client.getRegistryNumber() == null)
			throw new Exception("Client registry number can't be empty");

		if (client.getRegistryType() == null)
			throw new Exception("Client registry type can't be empty");

	}

}
