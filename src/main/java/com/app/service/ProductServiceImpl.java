package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.CategoryRepository;
import com.app.dao.ProductRepository;
import com.app.dao.SellerRepository;
import com.app.dto.ProductDto;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.Seller;
import com.app.exceptions.ResourceNotFoundException;
import com.app.utils.IStorageService;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private IStorageService StorageService;
	
	@Autowired
    private CategoryRepository catRepo;
	
	@Autowired
	private SellerRepository sellerRepo;

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product saveProductWithImage(Product product, MultipartFile productImage,long categoryId ,long sellerId) {
		
		Category category = catRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category Id "+categoryId+"Not Exist"));
		
		Seller seller = sellerRepo.findById(sellerId)
				.orElseThrow(()-> new ResourceNotFoundException("Seller Id "+sellerId+"Not Exist"));
		
		String fileName = StorageService.store(productImage);
		product.setProductImage(fileName);
		
		product.setCategory(category);
		product.setSeller(seller);
		
		return productRepo.save(product);
		
	}
	
	
//	@Override
//	public Product saveProductWithImage(Product product, MultipartFile productImage,long sellerId,long categoryId) {
//		String fileName = StorageService.store(productImage);
//		product.setProductImage(fileName);
//		product.setCategory(product.getCategory());
//		product.setSeller(product.getSeller());
//		return productRepo.save(product);
//	}

}
