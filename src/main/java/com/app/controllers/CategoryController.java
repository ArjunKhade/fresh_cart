package com.app.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CategoryDto;
import com.app.entities.Category;
import com.app.exceptions.CategoryHandlingException;
import com.app.service.ICategoryService;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

	   @Autowired
	    private ICategoryService categoryService;
	   
	   @Autowired
	   private ModelMapper modelMapper;
	
	   @GetMapping("")   
	   public ResponseEntity<?> findAllCategory(){
		List<Category> categoryList = categoryService.getAllCategory();
		if(categoryList.isEmpty()) {
			throw new CategoryHandlingException("Category List is Empty!!!");
		}
		return ResponseEntity.ok(categoryList);
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> saveCategoryWithImage(CategoryDto catDto){
		Category savedCategory= categoryService.saveCategoryWithImage(modelMapper.map(catDto, Category.class),catDto.getCategoryImage());
		return ResponseEntity.ok(savedCategory);
	}
	
	
	
	
	
	
	
}
