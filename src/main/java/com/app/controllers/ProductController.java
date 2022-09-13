package com.app.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDto;
import com.app.entities.Product;
import com.app.exceptions.ProductHandlingException;
import com.app.service.ICategoryService;
import com.app.service.IProductService;

@CrossOrigin
@RequestMapping("/products")
@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	   private ModelMapper modelMapper;
	
	@GetMapping("")
	public ResponseEntity<?>getAllProducts(){
		List<Product>productList = productService.getAllProduct();
		if(productList.isEmpty()) {
			throw new ProductHandlingException("Product List is Empty!!!");
		}
		return ResponseEntity.ok(productList);
	}
	//@PostMapping("/image")
	@PostMapping("/category/{categoryId}/seller/{sellerId}")
	public ResponseEntity<?> saveProductWithImage(ProductDto productDto,@PathVariable long categoryId,@PathVariable long sellerId){
		Product savedProduct= productService.saveProductWithImage(modelMapper.map(productDto, Product.class),productDto.getProductImage(),categoryId,sellerId);
		return ResponseEntity.ok(savedProduct);
	}
	
	
}
