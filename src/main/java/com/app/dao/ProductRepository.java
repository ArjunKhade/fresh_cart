package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.Seller;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findById(Long id);

	Optional<Product> findByProductName(String name);
	
	List<Product> findAllByProductName(String name);
	
	List<Product> findAllByCategory(Category category);
	
	List<Product> findAllBySeller(Seller seller);
	
}
