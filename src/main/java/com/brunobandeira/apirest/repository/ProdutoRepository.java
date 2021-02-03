package com.brunobandeira.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunobandeira.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);
	
}
