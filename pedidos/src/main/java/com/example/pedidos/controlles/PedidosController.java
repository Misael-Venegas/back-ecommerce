package com.example.pedidos.controlles;

import org.springframework.web.bind.annotation.RestController;

import com.example.commons.controllers.CommonController;
import com.example.commons.dto.PedidosRequest;
import com.example.commons.dto.PedidosResponse;
import com.example.pedidos.services.PedidoService;

@RestController
public class PedidosController extends CommonController<PedidosRequest, PedidosResponse, PedidoService>{

	public PedidosController(PedidoService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
