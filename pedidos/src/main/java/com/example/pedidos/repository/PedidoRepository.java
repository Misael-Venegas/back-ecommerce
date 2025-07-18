package com.example.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.commons.entities.Pedidos;

import feign.Param;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long> {

	@Query("SELECT COUNT(p) > 0 FROM Pedidos p JOIN p.productos pr WHERE pr.idProducto = :idProducto")
	boolean existeProductoId(@Param("idProducto") Long idProducto);

	@Query("SELECT COUNT(p) > 0 FROM Pedidos p WHERE p.idCliente = :idCliente")
	boolean existeClienteId(@Param("idCliente") Long idCliente);

	@Query(value = "SELECT p.id_pedido, p.id_cliente, p.total, p.fecha_creacion, p.estado, c.nombre , c.apellido FROM pedidos p INNER JOIN cliente c ON c.id_cliente = p.id_cliente WHERE  p.estado != 'CANCELADO'", nativeQuery = true)
	List<Pedidos> obtenerListaPedidos();
}
