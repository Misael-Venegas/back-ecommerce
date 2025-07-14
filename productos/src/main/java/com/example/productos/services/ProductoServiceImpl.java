package com.example.productos.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.commons.dto.ProductosRequest;
import com.example.commons.dto.ProductosResponse;
import com.example.commons.entities.Producto;
import com.example.productos.mappers.ProductoMapper;
import com.example.productos.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	private ProductoRepository repository;
	
	private ProductoMapper mapper;
	
	public ProductoServiceImpl(ProductoRepository repository, ProductoMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<ProductosResponse> listar() {
		List<ProductosResponse> productos = new ArrayList<>();
		repository.findAll().forEach(producto -> {
			productos.add(mapper.entityToResponse(producto));
		});
		return productos;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ProductosResponse> obtenerPorID(Long id) {
		Producto producto = repository.findById(id).orElseThrow(NoSuchElementException::new);
		return Optional.of(mapper.entityToResponse(producto));
	}

	@Override
	@Transactional
	public ProductosResponse insertar(ProductosRequest request) {
		Producto producto = mapper.requestToEntity(request);
		return mapper.entityToResponse(repository.save(producto));
	}

	@Override
	@Transactional
	public ProductosResponse actualizar(ProductosRequest request, Long id) {
		Producto producto = repository.findById(id).orElseThrow(NoSuchElementException::new);
		producto.setNombre(request.nombre());
		producto.setDescripcion(request.descripcion());
		producto.setPrecio(request.precio());
		producto.setStock(request.stock());
		return mapper.entityToResponse(repository.save(producto));
	}

	@Override
	@Transactional
	public ProductosResponse eliminar(Long id) {
		Producto producto = repository.findById(id).orElseThrow(NoSuchElementException::new);
		repository.deleteById(id);
		return mapper.entityToResponse(producto);
	}
	
}
