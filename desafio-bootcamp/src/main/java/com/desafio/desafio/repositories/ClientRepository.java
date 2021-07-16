package com.desafio.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desafio.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
