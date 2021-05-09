package com.labsit.codetest.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.labsit.codetest.enums.TransactionType;

@Entity
public class Transaction {

	@Id
	private Long id;

	private TransactionType transactionType;

	private Double price;

	private Date transactionDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

}
