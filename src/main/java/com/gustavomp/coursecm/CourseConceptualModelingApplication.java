package com.gustavomp.coursecm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavomp.coursecm.domain.Categoria;
import com.gustavomp.coursecm.repositories.CategoriaRepository;

@SpringBootApplication
public class CourseConceptualModelingApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository rep;
	
	public static void main(String[] args) {
		SpringApplication.run(CourseConceptualModelingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		rep.saveAll(Arrays.asList(c1, c2));
	}

}
