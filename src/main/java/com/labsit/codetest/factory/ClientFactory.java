package com.labsit.codetest.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.labsit.codetest.DTO.ClientDTO;
import com.labsit.codetest.enums.RegistryType;
import com.labsit.codetest.model.Client;

public class ClientFactory {

	@Autowired
	private CheckingAccountFactory checkingAccountFactory;

	public Client create(ClientDTO clientDto) {
		Client client = new Client();

		client.setAccount(checkingAccountFactory.create(clientDto.getAgency(), clientDto.getCheckingAccount()));
		client.setRegistryNumber(clientDto.getRegistryNumber());
		client.setRegistryType(RegistryType.valueOf(clientDto.getRegistryType()));

		return client;
	}

}
