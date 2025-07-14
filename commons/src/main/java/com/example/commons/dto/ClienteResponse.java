package com.example.commons.dto;

public record ClienteResponse(
		
		Long id_cliente,
		String nombre,
		String apellido,
		String email,
		Long telefono,
		String direccion
		
	
		) {
		
}
