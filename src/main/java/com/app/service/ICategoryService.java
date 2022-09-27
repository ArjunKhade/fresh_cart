package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.entities.Category;

public interface ICategoryService {

	List<Category> getAllCategory();
	
	Category saveCategory(Category category);
	
	Category saveCategoryWithImage(Category category,MultipartFile categoryImage);
	
	ApiResponse deleteByCategoryId(long id);
	ApiResponse deleteByCategoryName(String name);
	
	Category findByCategoryId(long id);
	Category findByCategoryName(String name);
	
}
