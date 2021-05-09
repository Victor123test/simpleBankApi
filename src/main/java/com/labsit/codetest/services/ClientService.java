package com.labsit.codetest.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsit.codetest.DTO.ClientDTO;
import com.labsit.codetest.factory.ClientFactory;
import com.labsit.codetest.model.Client;
import com.labsit.codetest.repository.ClientRepository;
import com.labsit.codetest.validators.ClientValidator;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientFactory clientFactory;
	
	@Autowired
	private ClientValidator clientValidator;

	@Transactional
	private Client insert(Client client) {
		clientRepository.save(client);
		return client;
	}

	public Client create(ClientDTO clientDto) throws Exception {
		Client client = clientFactory.create(clientDto);
		clientValidator.validate(client);
		return insert(client);
	}
}
