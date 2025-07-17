package com.example.cliente.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pedidos")
public interface PedidoClient {
	
	@GetMapping("/id-cliente/{id}")
	boolean clienteIsPresent(@PathVariable Long id);

}
