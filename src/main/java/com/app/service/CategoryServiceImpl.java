package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.CategoryRepository;
import com.app.entities.Category;
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
		return categoryRepo.findAll();
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

}
