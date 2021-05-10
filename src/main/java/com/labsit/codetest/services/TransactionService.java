package com.labsit.codetest.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsit.codetest.enums.TransactionType;
import com.labsit.codetest.factory.TransactionFactory;
import com.labsit.codetest.model.CheckingAccount;
import com.labsit.codetest.model.Transaction;
import com.labsit.codetest.repository.TransactionRepository;
import com.labsit.codetest.validators.TransactionValidator;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private TransactionFactory transactionFactory;

	@Autowired
	private TransactionValidator transactionValidator;

	@Transactional
	public CheckingAccount handleTransaction(CheckingAccount account, TransactionType type, Double value)
			throws Exception {
		Transaction transaction = transactionFactory.create(type, value, account.getBalance());
		save(transaction);
		List<Transaction> transactionsList = account.getTransactions();
		transactionsList.add(transaction);
		account.setTransactions(transactionsList);
		account.setBalance(transaction.getNewBalance());
		return account;
	}

	private void save(Transaction transaction) throws Exception {
		transactionValidator.validate(transaction);
		transactionRepository.save(transaction);
	}

}
