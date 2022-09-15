package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.entities.Category;

public interface ICategoryService {

	List<Category> getAllCategory();
	
	Category saveCategory(Category category);
	
	Category saveCategoryWithImage(Category category,MultipartFile categoryImage);
	
	
}
