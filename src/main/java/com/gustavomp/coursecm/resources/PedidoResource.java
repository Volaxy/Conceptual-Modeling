package com.gustavomp.coursecm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gustavomp.coursecm.domain.Pedido;
import com.gustavomp.coursecm.services.PedidoService;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoResource {
	
	@Autowired
	PedidoService service;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}
