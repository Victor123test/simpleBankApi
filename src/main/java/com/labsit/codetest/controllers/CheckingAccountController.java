package com.labsit.codetest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labsit.codetest.DTO.BalanceDTO;
import com.labsit.codetest.DTO.TransactionDTO;
import com.labsit.codetest.model.Transaction;
import com.labsit.codetest.services.CheckingAccountService;

@CrossOrigin
@RestController
@RequestMapping("/api/checking-account")
public class CheckingAccountController {

	@Autowired
	private CheckingAccountService checkingAccountService;

	@PostMapping("/deposit")
	public BalanceDTO deposit(@RequestBody TransactionDTO transaction) throws Exception {
		return checkingAccountService.deposit(transaction);
	}

	@PostMapping("/withdraw")
	public BalanceDTO withdraw(@RequestBody TransactionDTO transaction) throws Exception {
		return checkingAccountService.withdraw(transaction);
	}

	@GetMapping("/balance/{account}")
	public BalanceDTO balance(@PathVariable String account) {
		return checkingAccountService.getBalance(account);
	}

	@GetMapping("/statement/{account}")
	public List<Transaction> statement(@PathVariable String account) {
		return checkingAccountService.getStatement(account);
	}
}
