package com.gustavomp.coursecm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavomp.coursecm.domain.Categoria;
import com.gustavomp.coursecm.domain.Produto;
import com.gustavomp.coursecm.repositories.CategoriaRepository;
import com.gustavomp.coursecm.repositories.ProdutoRepository;

@SpringBootApplication
public class CourseConceptualModelingApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CourseConceptualModelingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().add(p2);
		
		p1.getCategorias().add(c1);
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().add(c1);
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
