package com.labsit.codetest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsit.codetest.model.Agency;
import com.labsit.codetest.repository.AgencyRepository;
import com.labsit.codetest.validators.AgencyValidator;

@Service
public class AgencyService {

	@Autowired
	private AgencyValidator agencyValidator;

	@Autowired
	private AgencyRepository agencyRepository;

	public Agency findByNumber(String agencyNumber) {
		return agencyRepository.findByNumber(agencyNumber);
	}

	public Agency getAgency(String agencyNumber) throws Exception {
		Agency ag = findByNumber(agencyNumber);
		if (ag != null)
			return ag;
		return create(agencyNumber);
	}

	public Agency create(String agencyNumber) throws Exception {
		Agency ag = new Agency();
		ag.setNumber(agencyNumber);
		save(ag);
		return ag;
	}

	public void save(Agency ag) throws Exception {
		agencyValidator.validate(ag);
		agencyRepository.save(ag);
	}
}
