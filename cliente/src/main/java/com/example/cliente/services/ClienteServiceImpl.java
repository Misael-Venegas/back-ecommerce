package com.example.cliente.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cliente.clients.PedidoClient;
import com.example.cliente.mappers.ClienteMapper;
import com.example.cliente.repositories.ClienteRepository;
import com.example.commons.dto.ClienteRequest;
import com.example.commons.dto.ClienteResponse;
import com.example.commons.entities.Cliente;
import com.example.commons.exceptions.EntidadRelacionadaException;

@Service
public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository clienteRepository;
	
	private ClienteMapper clienteMapper;
	
	private PedidoClient pedidoClient;

	

	public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper,
			PedidoClient pedidoClient) {
		super();
		this.clienteRepository = clienteRepository;
		this.clienteMapper = clienteMapper;
		this.pedidoClient = pedidoClient;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClienteResponse> listar() {
		List<ClienteResponse> clientes = new ArrayList<>();
		clienteRepository.findAll().forEach(cliente -> {
			clientes.add(clienteMapper.entityToResponse(cliente));
		});
		return clientes;
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ClienteResponse> obtenerPorID(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(NoSuchElementException:: new);
		return Optional.of(clienteMapper.entityToResponse(cliente));
	}

	@Override
	@Transactional
	public ClienteResponse insertar(ClienteRequest request) {
		Cliente cliente = clienteMapper.requestToEntity(request);
		return clienteMapper.entityToResponse(clienteRepository.save(cliente));
	}

	@Override
	@Transactional
	public ClienteResponse actualizar(ClienteRequest request, Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(NoSuchElementException:: new);
		cliente.setNombre(request.nombre());
		cliente.setApellido(request.apellido());
		cliente.setEmail(request.email());
		cliente.setTelefono(request.telefono());
		cliente.setDireccion(request.direccion());
		
		return clienteMapper.entityToResponse(clienteRepository.save(cliente));
	}

	@Override
	@Transactional
	public ClienteResponse eliminar(Long id) {
		
		Cliente cliente = clienteRepository.findById(id).orElseThrow(NoSuchElementException:: new);
		
		boolean enUso = pedidoClient.clienteIsPresent(id);
		
		if (enUso) {
			throw new EntidadRelacionadaException("No se pudo eliminar el CLIENTE ya que está asociado a un PEDIDO");
		} else {
			clienteRepository.deleteById(id);
			return clienteMapper.entityToResponse(cliente);
		}
		
	}
	
	
}
