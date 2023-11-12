package com.michael.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michael.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
