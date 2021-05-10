package com.labsit.codetest.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labsit.codetest.model.CheckingAccount;
import com.labsit.codetest.services.CheckingAccountService;

@Component
public class CheckingAccountValidator {

	public void validate(CheckingAccount checkingAccount) throws Exception {

		if (checkingAccount.getAccountNumber() == null)
			throw new Exception("Client account number can't be empty");

		if (!StringUtils.isNumeric(checkingAccount.getAccountNumber()))
			throw new Exception("Account must be a valid number");

		if (checkingAccount.getAgency() == null)
			throw new Exception("Agency can't be empty");
	}
}
