package com.labsit.codetest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labsit.codetest.DTO.ClientDTO;
import com.labsit.codetest.model.Client;
import com.labsit.codetest.services.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/api/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("")
	public Client create(@RequestBody ClientDTO clientDto) throws Exception {
		return clientService.create(clientDto);
	}

	@GetMapping("")
	public List<Client> findAll() {
		return clientService.findAll();
	}

	@PutMapping("")
	public Client update(@RequestBody Client client) {
		return clientService.update(client);
	}
}
