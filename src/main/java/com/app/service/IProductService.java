package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.entities.Product;

public interface IProductService {
    
	List<Product>getAllProduct();
	
	List<Product> findAllByProductName(String name);
	
	Product saveProduct (Product product);
	
	Product saveProductWithImage(Product product,MultipartFile productImage,long categoryId,long sellerId);
	
	Product findByProductId(long id);
	
	Product findByProductName(String name);
	
	ApiResponse deleteByProductId(long id);
	
	ApiResponse deleteByProductName(String name);
	
	List<Product> findProductsByCategoryId(long catId);
	
	List<Product> findProductsBySellerId(long sellerId);
	
}
