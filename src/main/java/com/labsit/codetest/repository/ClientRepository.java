package com.labsit.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labsit.codetest.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
