package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ProductDto;
import com.app.entities.Product;

public interface IProductService {
    
	List<Product>getAllProduct();
	
	Product saveProduct (Product product);
	
	Product saveProductWithImage(Product product,MultipartFile productImage,long sellerId,long categoryId);
	
	
}
