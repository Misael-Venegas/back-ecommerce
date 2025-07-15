package com.example.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.commons.entities.Pedidos;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long>{
	
	@Query("SELECT COUNT(p) > 0 FROM Pedido p WHERE p.idProducto = :idProducto")
	boolean existeProductoId(@Param("idProducto") Long idProducto);
	
}
