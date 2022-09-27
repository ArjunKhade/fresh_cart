package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	 Optional<Category> findById(Long id);
	 Optional<Category> findByCategoryName(String name);
	
}
