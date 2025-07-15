package com.example.cliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commons.entities.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	//QUERY SI ES USADO EN ALGUN LADO

}
