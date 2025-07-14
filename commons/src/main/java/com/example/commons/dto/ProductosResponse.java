package com.example.commons.dto;

public record ProductosResponse(
		Long id,
		String nombre,
		String descricpion,
		float precio,
		int stock
) {}
