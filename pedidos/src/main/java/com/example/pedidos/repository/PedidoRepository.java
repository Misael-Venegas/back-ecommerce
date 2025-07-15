package com.example.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commons.entities.Pedidos;
@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long>{
	

}
