package com.labsit.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.labsit.codetest.model.CheckingAccount;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
	
	@Query("FROM CheckingAccount WHERE accountNumber = ?1")
	CheckingAccount findByNumber(String accountNumber);

}
