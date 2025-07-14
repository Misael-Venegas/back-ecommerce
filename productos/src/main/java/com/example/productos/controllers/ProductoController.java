package com.example.productos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.commons.controllers.CommonController;
import com.example.commons.dto.ProductosRequest;
import com.example.commons.dto.ProductosResponse;
import com.example.productos.services.ProductoService;

@RestController
public class ProductoController extends CommonController<ProductosRequest, ProductosResponse, ProductoService>{

	public ProductoController(ProductoService service) {
		super(service);
	}
	
}
