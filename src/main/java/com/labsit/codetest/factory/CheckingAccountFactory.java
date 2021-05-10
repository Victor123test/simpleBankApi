package com.labsit.codetest.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labsit.codetest.model.Agency;
import com.labsit.codetest.model.CheckingAccount;
import com.labsit.codetest.services.AgencyService;

@Component
public class CheckingAccountFactory {

	@Autowired
	private AgencyService agencyService;

	public CheckingAccount create(String AgencyNumber, String accountNumber) throws Exception {
		Agency ag = agencyService.getAgency(AgencyNumber);
		CheckingAccount account = new CheckingAccount();
		account.setBalance(0.0);
		account.setAgency(ag);
		account.setAccountNumber(accountNumber);
		return account;
	}
}
