package com.gustavomp.coursecm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gustavomp.coursecm.domain.Cliente;
import com.gustavomp.coursecm.services.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}
