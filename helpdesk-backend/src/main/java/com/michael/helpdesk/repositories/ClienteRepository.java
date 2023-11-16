package com.michael.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michael.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
