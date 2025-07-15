package com.example.cliente.mappers;

import com.example.commons.dto.ClienteRequest;
import com.example.commons.dto.ClienteResponse;
import com.example.commons.entities.Cliente;
import com.example.commons.mappers.CommonMapper;

public class ClienteMapper extends CommonMapper<ClienteRequest, ClienteResponse, Cliente>{

	
	public ClienteMapper() {
		
	}

	@Override
	protected ClienteResponse entityToResponse(Cliente entity) {
		if (entity == null) {
			return null;
		}
		
		ClienteResponse clienteResponse = new ClienteResponse(entity.getId_cliente(),
				entity.getNombre(), entity.getApellido(), entity.getEmail(),
				entity.getTelefono(), entity.getDireccion());
		return clienteResponse;
	}

	@Override
	protected Cliente requestToEntity(ClienteRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
