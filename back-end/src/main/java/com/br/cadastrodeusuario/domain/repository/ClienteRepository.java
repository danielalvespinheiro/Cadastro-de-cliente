package com.br.cadastrodeusuario.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cadastrodeusuario.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
