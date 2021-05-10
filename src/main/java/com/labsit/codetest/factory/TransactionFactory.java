package com.labsit.codetest.factory;



import java.util.Date;

import org.springframework.stereotype.Component;

import com.labsit.codetest.enums.TransactionType;
import com.labsit.codetest.model.Transaction;

@Component
public class TransactionFactory {

	public Transaction create(TransactionType type, Double value, Double balance) {

		Transaction transaction = new Transaction();
		transaction.setValue(value);
		transaction.setTransactionType(type);
		transaction.setTransactionDate(new Date());

		if (type == TransactionType.DEPOSIT)
			transaction.setNewBalance(balance + value);

		if (type == TransactionType.WITHDRAW)
			transaction.setNewBalance(balance - value);

		return transaction;

	}

}
