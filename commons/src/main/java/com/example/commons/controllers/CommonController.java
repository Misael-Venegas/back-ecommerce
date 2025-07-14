package com.example.commons.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.commons.services.CommonService;

import jakarta.validation.constraints.Min;

@Validated
public class CommonController<RQ, RS, S extends CommonService<RQ, RS>> {
	
	protected S service;
	
	public CommonController(S service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<RS>> listar() {
		List<RS> response = service.listar();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RS> obtenerPorId(@PathVariable @Min(value = 1, message = "El ID debe ser positivo") Long id) {
		return ResponseEntity.ok(service.obtnerPorID(id)
				.orElseThrow(NoSuchElementException::new));
	}
	
}