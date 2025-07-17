package com.example.pedidos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.commons.dto.PedidosRequest;
import com.example.commons.dto.PedidosResponse;
import com.example.commons.entities.Pedidos;
import com.example.pedidos.PedidosApplication;
import com.example.pedidos.mapper.PedidoMapper;
import com.example.pedidos.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	private final PedidosApplication pedidosApplication;

	private PedidoRepository repository;
	private PedidoMapper mapper;

	public PedidoServiceImpl(PedidoRepository repository, PedidoMapper mapper, PedidosApplication pedidosApplication) {

		this.repository = repository;
		this.mapper = mapper;
		this.pedidosApplication = pedidosApplication;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PedidosResponse> listar() {

		List<PedidosResponse> pedidos = new ArrayList<>();
		repository.findAll().forEach(pedido -> {
			pedidos.add(mapper.entityToResponse(pedido));
		});
		return pedidos;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PedidosResponse> obtenerPorID(Long id) {
		Pedidos pedido = repository.findById(id).orElseThrow(NoSuchElementException::new);
		return Optional.of(mapper.entityToResponse(pedido));
	}

	@Override
	@Transactional
	public PedidosResponse insertar(PedidosRequest request) {
		Pedidos pedido = mapper.requestToEntity(request);
		return mapper.entityToResponse(repository.save(pedido));
	}

	@Override
	@Transactional
	public PedidosResponse actualizar(PedidosRequest request, Long id) {
		Pedidos pedido = repository.findById(id).orElseThrow(NoSuchElementException::new);
		pedido.setEstado(request.estado());
		pedido.setFechaCreacion(request.fechaCreacion());
		pedido.setIdCliente(request.idCliente());
		pedido.setProductos(request.productos());
		pedido.setTotal(request.total());

		return mapper.entityToResponse(repository.save(pedido));
	}

	@Override
	@Transactional
	public PedidosResponse eliminar(Long id) {

		Pedidos pedido = repository.findById(id).orElseThrow(NoSuchElementException::new);
		repository.deleteById(id);
		return mapper.entityToResponse(pedido);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public boolean existeProducto(Long id) {
		return repository.existeProductoId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existeCliente(Long id) {
		return repository.existeClienteId(id);
	}

}
