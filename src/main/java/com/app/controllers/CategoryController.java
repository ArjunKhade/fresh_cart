package com.app.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CategoryDto;
import com.app.entities.Category;
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
		return ResponseEntity.ok(categoryList);
	}
	
	@PostMapping("")
	public ResponseEntity<?> saveCategoryWithImage(CategoryDto catDto){
		Category savedCategory= categoryService.saveCategoryWithImage(modelMapper.map(catDto, Category.class),catDto.getCategoryImage());
		return ResponseEntity.ok(savedCategory);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findByCategoryId(@PathVariable("id") long  categoryId) {
		Category newCategory=categoryService.findByCategoryId(categoryId);
		return ResponseEntity.ok(newCategory);
	}

	@GetMapping("name/{name}")
	public ResponseEntity<?> findByCategoryName(@PathVariable("name") String categoryName) {
		Category newCategory = categoryService.findByCategoryName(categoryName);
	return ResponseEntity.ok(newCategory);

	}
	
	@PutMapping("/name/{name}")
	public ResponseEntity<?> updateCategoryByName(CategoryDto catDto, @PathVariable("name") String name) {
		Category category = categoryService.findByCategoryName(name);
		category.setCategoryName(catDto.getCategoryName());
		category.setCategoryDescription(catDto.getCategoryDescription());
		categoryService.saveCategoryWithImage(category, catDto.getCategoryImage());
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Category With Id "+category.getId()+"Updated Successfully!!!"));
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable("id") long id) {
		Category category = categoryService.findByCategoryId(id);
	 ApiResponse response = categoryService.deleteByCategoryId(category.getId());
	   return  ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/name/{name}")
	public ResponseEntity<?> deleteCategoryByName(@PathVariable("name") String name) {
		Category category = categoryService.findByCategoryName(name);
		 ApiResponse response  = categoryService.deleteByCategoryName(category.getCategoryName());
	     return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
}
