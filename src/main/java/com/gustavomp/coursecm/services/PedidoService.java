package com.gustavomp.coursecm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavomp.coursecm.domain.Pedido;
import com.gustavomp.coursecm.repositories.PedidoRepository;
import com.gustavomp.coursecm.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository rep;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = rep.findById(id);
		
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()
		));
	}
	
}
