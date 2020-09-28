package com.gustavomp.coursecm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavomp.coursecm.domain.Categoria;
import com.gustavomp.coursecm.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository rep;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = rep.findById(id);
		
		return categoria.orElse(null);
	}
	
}
