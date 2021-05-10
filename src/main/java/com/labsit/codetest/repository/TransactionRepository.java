package com.labsit.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labsit.codetest.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
