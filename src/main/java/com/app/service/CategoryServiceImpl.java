package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.CategoryRepository;
import com.app.dto.ApiResponse;
import com.app.entities.Category;
import com.app.exceptions.CategoryHandlingException;
import com.app.utils.IStorageService;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private IStorageService storageService;

	@Override
	public List<Category> getAllCategory() {
		List<Category> categoryList = categoryRepo.findAll();
		if(categoryList.isEmpty()) {
			throw new CategoryHandlingException("Category List is Empty!!!");
		}
		return categoryList;
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category saveCategoryWithImage(Category category, MultipartFile categoryImage) {
		String fileName = storageService.store(categoryImage);
		category.setCategoryImage(fileName);
		return categoryRepo.save(category);
	}

	
	@Override
	public ApiResponse deleteByCategoryId(long id) {
		Category category = categoryRepo.findById(id)
				.orElseThrow(()-> new CategoryHandlingException("Category With Category Id  "+id +" Not Found "));
	     categoryRepo.delete(category); 
		return new ApiResponse ("Category  with Id "+category.getId()+" Deleted Successfully ");
	}

	@Override
	public ApiResponse deleteByCategoryName(String name) {
		Category category = categoryRepo.findByCategoryName(name)
				.orElseThrow(()-> new CategoryHandlingException("Category With Category Name  "+name +" Not Found "));
	     categoryRepo.delete(category);
		return new ApiResponse ("Category  with Id "+category.getCategoryName()+" Deleted Successfully ");
	}

	@Override
	public Category findByCategoryId(long id) {
		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new CategoryHandlingException("Category With Category Id "+id +" Not Found"));
		return category;
	}

	@Override
	public Category findByCategoryName(String name) {
		Category category = categoryRepo.findByCategoryName(name)
				.orElseThrow(()-> new CategoryHandlingException("Category With Category Name  "+name +" Not Found "));
		return category;
	}

}
