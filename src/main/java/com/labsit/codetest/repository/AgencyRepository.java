package com.labsit.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.labsit.codetest.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

	@Query("FROM Agency WHERE number = ?1")
	Agency findByNumber(String agencyNumber);

}
