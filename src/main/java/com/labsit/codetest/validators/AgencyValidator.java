package com.labsit.codetest.validators;

import org.springframework.stereotype.Component;

import com.labsit.codetest.model.Agency;

@Component
public class AgencyValidator {

	public void validate(Agency ag) throws Exception {

		if (ag == null)
			throw new Exception("Agency cant be null");

		if (ag.getNumber() == null)
			throw new Exception("Agency number cant be empty");
	}

}
