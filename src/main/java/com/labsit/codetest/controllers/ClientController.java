package com.labsit.codetest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labsit.codetest.DTO.ClientDTO;
import com.labsit.codetest.model.Client;
import com.labsit.codetest.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@PostMapping("/")
	public Client save(@RequestBody ClientDTO clientDto) {
		return clientService.create(clientDto);
	}
	

}
