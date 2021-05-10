package com.labsit.codetest.factory;

import org.springframework.stereotype.Component;

import com.labsit.codetest.DTO.BalanceDTO;
import com.labsit.codetest.model.CheckingAccount;

@Component
public class BalanceDtoFactory {

	public BalanceDTO create(CheckingAccount account) {
		BalanceDTO balance = new BalanceDTO();
		balance.setAccount(account.getAccountNumber());
		balance.setAgency(account.getAgency().getNumber());
		balance.setBalance(account.getBalance());
		balance.setClientName(account.getClient().getName());
		return balance;

	}

}
