package com.labsit.codetest.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsit.codetest.DTO.BalanceDTO;
import com.labsit.codetest.DTO.TransactionDTO;
import com.labsit.codetest.enums.TransactionType;
import com.labsit.codetest.factory.BalanceDtoFactory;
import com.labsit.codetest.factory.CheckingAccountFactory;
import com.labsit.codetest.model.CheckingAccount;
import com.labsit.codetest.model.Client;
import com.labsit.codetest.model.Transaction;
import com.labsit.codetest.repository.CheckingAccountRepository;
import com.labsit.codetest.validators.CheckingAccountValidator;

@Service
public class CheckingAccountService {

	@Autowired
	private CheckingAccountRepository checkingAccountRepository;

	@Autowired
	private CheckingAccountFactory checkingAccountFactory;

	@Autowired
	private CheckingAccountValidator checkingAccountValidator;

	@Autowired
	private BalanceDtoFactory balanceDtoFactory;

	@Autowired
	private TransactionService transactionService;

	@Transactional
	private void save(CheckingAccount account) throws Exception {
		checkingAccountValidator.validate(account);
		checkingAccountRepository.save(account);
	}

	@Transactional
	private CheckingAccount handleTransactions(String accountNumber, TransactionType type, Double value)
			throws Exception {
		CheckingAccount account = findByNumber(accountNumber);
		account = transactionService.handleTransaction(account, type, value);
		save(account);
		return account;
	}

	public void inserClient(CheckingAccount account, Client client) throws Exception {
		account.setClient(client);
		save(account);
	}

	public CheckingAccount findByNumber(String accountNumber) {
		return checkingAccountRepository.findByNumber(accountNumber);
	}

	@Transactional
	public CheckingAccount create(String AgencyNumber, String accountNumber) throws Exception {
		CheckingAccount account = checkingAccountFactory.create(AgencyNumber, accountNumber);
		save(account);
		return account;
	}

	public BalanceDTO withdraw(TransactionDTO transaction) throws Exception {
		CheckingAccount account = handleTransactions(transaction.getAccount(), TransactionType.WITHDRAW,
				transaction.getValue());
		return balanceDtoFactory.create(account);
	}

	public BalanceDTO deposit(TransactionDTO transaction) throws Exception {
		CheckingAccount account = handleTransactions(transaction.getAccount(), TransactionType.DEPOSIT,
				transaction.getValue());
		return balanceDtoFactory.create(account);
	}

	public BalanceDTO getBalance(String accountNumber) {
		CheckingAccount account = findByNumber(accountNumber);
		return balanceDtoFactory.create(account);
	}

	public List<Transaction> getStatement(String accountNumber) {
		CheckingAccount account = findByNumber(accountNumber);
		if (account != null)
			return account.getTransactions();
		return null;
	}

}
