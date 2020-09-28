package com.gustavomp.coursecm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavomp.coursecm.domain.Produto;
import com.gustavomp.coursecm.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository rep;
	
	public Produto buscar(Integer id) {
		Optional<Produto> produto = rep.findById(id);
		
		return produto.orElse(null);
	}
	
}
