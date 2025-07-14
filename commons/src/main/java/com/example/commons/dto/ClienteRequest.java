package com.example.commons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteRequest(
		
		@NotBlank(message = "El nombre es requerido.")
		String nombre,
		
		@NotBlank(message = "El apellido es requerido.")
		String apellido,
		
		@Email
		String email,
		
		@NotNull(message = "El numero de telefono es requerido.")
		@Size(min = 10, max = 10, message = "El numero de telefono debe de tener 10 digitos")
		Long telefono,
		
		@Size(max = 100, message = "La direccion no puede exceder los 100 caracteres.")
		String direccion
		
		
		) {
	
	
}
