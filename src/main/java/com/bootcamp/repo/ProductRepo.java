package com.bootcamp.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.entity.Product;

public interface ProductRepo  extends CrudRepository<Product, Integer>{

	 public   Optional<Product> findByPname(String pname);
		 
	 
	
}
