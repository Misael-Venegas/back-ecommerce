package com.example.productos.mappers;

import org.springframework.stereotype.Component;

import com.example.commons.dto.ProductosRequest;
import com.example.commons.dto.ProductosResponse;
import com.example.commons.entities.Producto;
import com.example.commons.mappers.CommonMapper;

@Component
public class ProductoMapper extends CommonMapper<ProductosRequest, ProductosResponse, Producto>{
	
	@Override
	public ProductosResponse entityToResponse(Producto entity) {
		if (entity == null) {
			return null;
		}
		return new ProductosResponse(entity.getId(), entity.getNombre(), entity.getDescripcion(),
				entity.getPrecio(), entity.getStock());
	}

	@Override
	public Producto requestToEntity(ProductosRequest request) {
		if (request == null) {
			return null;
		}
		Producto producto = new Producto();
		producto.setNombre(request.nombre());
		producto.setDescripcion(request.descripcion());
		producto.setPrecio(request.precio());
		producto.setStock(request.stock());
		return producto;
	}

}
