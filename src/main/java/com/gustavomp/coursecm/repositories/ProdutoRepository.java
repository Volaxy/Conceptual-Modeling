package com.gustavomp.coursecm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavomp.coursecm.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
