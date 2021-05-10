package com.labsit.codetest.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsit.codetest.DTO.ClientDTO;
import com.labsit.codetest.factory.ClientFactory;
import com.labsit.codetest.model.CheckingAccount;
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

	@Autowired
	private CheckingAccountService checkingAccountService;

	@Transactional
	private void save(Client client) throws Exception {
		clientValidator.validate(client);
		clientRepository.save(client);
	}
	
	@Transactional
	public Client create(ClientDTO clientDto) throws Exception {
		Client client = clientFactory.create(clientDto);
		CheckingAccount account = checkingAccountService.create(clientDto.getAgency(), clientDto.getCheckingAccount());
		client.setAccount(account);
		save(client);
		checkingAccountService.inserClient(account, client);
		return client;
	}

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client update(Client client) {
		clientRepository.save(client);
		return client;
	}
}
