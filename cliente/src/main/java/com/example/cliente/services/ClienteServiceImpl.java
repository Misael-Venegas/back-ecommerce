package com.example.cliente.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cliente.mappers.ClienteMapper;
import com.example.cliente.repositories.ClienteRepository;
import com.example.commons.dto.ClienteRequest;
import com.example.commons.dto.ClienteResponse;
import com.example.commons.entities.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository clienteRepository;
	
	private ClienteMapper clienteMapper;

	public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
		super();
		this.clienteRepository = clienteRepository;
		this.clienteMapper = clienteMapper;
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
		//Se debe de verificar si el cliente está siendo usado en otro lugar antes de eliminar.
		
		clienteRepository.deleteById(id);
		return clienteMapper.entityToResponse(cliente);
		
	}
	
	
}
