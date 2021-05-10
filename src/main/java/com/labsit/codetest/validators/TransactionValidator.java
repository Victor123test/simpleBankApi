package com.labsit.codetest.validators;

import org.springframework.stereotype.Component;

import com.labsit.codetest.model.Transaction;

@Component
public class TransactionValidator {

	public void validate(Transaction transaction) throws Exception {

		if (transaction.getNewBalance() < 0)
			throw new Exception("You dont have enough money on your account");
	}

}
