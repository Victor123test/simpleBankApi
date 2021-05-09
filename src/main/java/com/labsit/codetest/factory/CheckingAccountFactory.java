package com.labsit.codetest.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.labsit.codetest.model.Agency;
import com.labsit.codetest.model.CheckingAccount;
import com.labsit.codetest.services.AgencyService;

public class CheckingAccountFactory {

	@Autowired
	private AgencyService agencyService;

	public CheckingAccount create(String AgencyNumber, String accountNumber) {
		Agency ag = agencyService.findByNumber(AgencyNumber);
		CheckingAccount chAccount = new CheckingAccount();
		chAccount.setAgency(ag);
		chAccount.setAccountNumber(accountNumber);
		return chAccount;
	}
}
