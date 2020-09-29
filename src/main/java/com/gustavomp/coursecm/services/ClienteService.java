package com.gustavomp.coursecm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavomp.coursecm.domain.Cliente;
import com.gustavomp.coursecm.repositories.ClienteRepository;
import com.gustavomp.coursecm.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository rep;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> cliente = rep.findById(id);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Id: " +
			id + ", Cliente: " + Cliente.class.getName()
		));
	}
	
}
