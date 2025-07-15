package com.example.pedidos.services;

import org.springframework.stereotype.Service;

import com.example.commons.dto.PedidosRequest;
import com.example.commons.dto.PedidosResponse;
import com.example.commons.services.CommonService;

@Service
public interface PedidoService extends CommonService<PedidosRequest, PedidosResponse>{

}
