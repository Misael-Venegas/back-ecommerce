package com.example.cliente.mappers;

import org.springframework.stereotype.Component;

import com.example.commons.dto.ClienteRequest;
import com.example.commons.dto.ClienteResponse;
import com.example.commons.entities.Cliente;
import com.example.commons.mappers.CommonMapper;

@Component
public class ClienteMapper extends CommonMapper<ClienteRequest, ClienteResponse, Cliente>{


	@Override
	public ClienteResponse entityToResponse(Cliente entity) {
		if (entity == null) {
			return null;
		}
		
		ClienteResponse clienteResponse = new ClienteResponse(entity.getId_cliente(),
				entity.getNombre(), entity.getApellido(), entity.getEmail(),
				entity.getTelefono(), entity.getDireccion());
		return clienteResponse;
	}

	@Override
	public Cliente requestToEntity(ClienteRequest request) {
		if (request == null) {
			return null;
		}
		
		Cliente cliente = new Cliente();
		
		cliente.setNombre(request.nombre());
		cliente.setApellido(request.apellido());
		cliente.setEmail(request.email());
		cliente.setTelefono(request.telefono());
		cliente.setDireccion(request.direccion());
		
		return cliente;
		
	}

}
