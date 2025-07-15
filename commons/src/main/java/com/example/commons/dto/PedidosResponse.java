package com.example.commons.dto;

import java.util.Date;
import java.util.List;

import com.example.commons.entities.ProductoPedido;

public record PedidosResponse(Long id, Long idCliente, Double total, Date fechaCreacion, String estado,
		List<ProductoPedido> productos) {

}
