package com.example.cliente.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.cliente.services.ClienteService;
import com.example.commons.controllers.CommonController;
import com.example.commons.dto.ClienteRequest;
import com.example.commons.dto.ClienteResponse;


@RestController
public class ClienteController extends CommonController<ClienteRequest, ClienteResponse, ClienteService >{

	public ClienteController(ClienteService service) {
		super(service);
	}
	
	

}
