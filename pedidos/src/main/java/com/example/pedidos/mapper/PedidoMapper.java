package com.example.pedidos.mapper;

import org.springframework.stereotype.Component;

import com.example.commons.dto.PedidosRequest;
import com.example.commons.dto.PedidosResponse;
import com.example.commons.entities.Pedidos;
import com.example.commons.mappers.CommonMapper;

@Component
public class PedidoMapper extends CommonMapper<PedidosRequest, PedidosResponse, Pedidos> {

	@Override
	public PedidosResponse entityToResponse(Pedidos entity) {
		if (entity == null) {
			return null;
		}
		return new PedidosResponse(entity.getId(), entity.getIdCliente(), entity.getTotal(), entity.getFechaCreacion(),
				entity.getEstado(), entity.getProductos());
	}

	@Override
	public Pedidos requestToEntity(PedidosRequest request) {
		if (request == null) {
			return null;
		}

		Pedidos pedido = new Pedidos();
		pedido.setEstado(request.estado());
		pedido.setFechaCreacion(request.fechaCreacion());
		pedido.setIdCliente(request.idCliente());
		pedido.setProductos(request.productos());
		pedido.setTotal(request.total());

		return pedido;

	}

}
