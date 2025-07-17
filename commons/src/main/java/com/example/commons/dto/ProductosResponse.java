package com.example.commons.dto;

public record ProductosResponse(
		Long id,
		String nombre,
		String descripcion,
		float precio,
		int stock
) {}
