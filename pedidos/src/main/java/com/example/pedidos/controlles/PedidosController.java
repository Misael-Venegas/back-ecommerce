package com.example.pedidos.controlles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.commons.controllers.CommonController;
import com.example.commons.dto.PedidosRequest;
import com.example.commons.dto.PedidosResponse;
import com.example.pedidos.services.PedidoService;

@RestController
public class PedidosController extends CommonController<PedidosRequest, PedidosResponse, PedidoService>{

	public PedidosController(PedidoService service) {
		super(service);
	}
	
	@GetMapping("/id-producto/{id}")
	public ResponseEntity<Boolean> productoIsPresent(@PathVariable Long id) {
		boolean isPresent = service.existeProducto(id);
		return ResponseEntity.ok(isPresent);
	}
	
	@GetMapping("/id-cliente/{id}")
	public ResponseEntity<Boolean> clienteIsPresent(@PathVariable Long id) {
		boolean isPresent = service.existeCliente(id);
		return ResponseEntity.ok(isPresent);
	}

}
