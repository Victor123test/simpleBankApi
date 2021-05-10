package com.labsit.codetest.factory;

import org.springframework.stereotype.Component;

import com.labsit.codetest.DTO.ClientDTO;
import com.labsit.codetest.enums.RegistryType;
import com.labsit.codetest.model.Client;

@Component
public class ClientFactory {

	public Client create(ClientDTO clientDto) throws Exception {
		Client client = new Client();
		client.setName(clientDto.getName());
		client.setRegistryNumber(clientDto.getRegistryNumber());
		client.setRegistryType(RegistryType.valueOf(clientDto.getRegistryType()));
		return client;
	}                                                                                                                                                                                                                                                                                                           

}
