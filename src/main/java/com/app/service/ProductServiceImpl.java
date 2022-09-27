package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.CategoryRepository;
import com.app.dao.ProductRepository;
import com.app.dao.SellerRepository;
import com.app.dto.ApiResponse;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.Seller;
import com.app.exceptions.CategoryHandlingException;
import com.app.exceptions.ProductHandlingException;
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
		List<Product> productList = productRepo.findAll();
		if(productList.isEmpty()) {
			throw new ProductHandlingException("Product List is Empty!!!");
		}
		return productList;
	}
	
	@Override
	public List<Product> findAllByProductName(String name) {
		List<Product> productList = productRepo.findAllByProductName(name);
		if(productList.isEmpty()) {
			throw new ProductHandlingException("Product List is Empty!!!");
		}
		return productList;
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product saveProductWithImage(Product product, MultipartFile productImage,long categoryId ,long sellerId) {
		
		Category category = catRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category Id "+categoryId+" Not Exist"));
		
		 
		Seller seller = sellerRepo.findById(sellerId)
				.orElseThrow(()-> new ResourceNotFoundException("Seller Id "+sellerId+"Not Exist"));
		
		String fileName = StorageService.store(productImage);
		product.setProductImage(fileName);
		
		product.setCategory(category);
		product.setSeller(seller);
		
		return productRepo.save(product);
		
	}

	@Override
	public Product findByProductId(long id) {
		Product product  = productRepo.findById(id)
				.orElseThrow(()-> new ProductHandlingException("Product with Id "+id+" Not found!!"));
		return product;
	}

	@Override
	public Product findByProductName(String name) {
		Product product = productRepo.findByProductName(name)
				.orElseThrow(()-> new ProductHandlingException("Product with Name "+name+" Not found!!"));
		return product;
	}

	@Override
	public ApiResponse deleteByProductId(long id) {
		Product product = findByProductId(id);
		productRepo.delete(product);
		return new ApiResponse("Product With Id "+id+"Deleted Successfully!!!!");
	}

	@Override
	public ApiResponse deleteByProductName(String name) {
		Product product = productRepo.findByProductName(name)
				.orElseThrow(()-> new ProductHandlingException("Product with Name "+name+" Not found!!"));
		productRepo.delete(product);
		return new ApiResponse("Product With Name "+name+"Deleted Successfully!!!!");
		
	}

	@Override
	public List<Product> findProductsByCategoryId(long catId) {
		  Category category = catRepo.findById(catId)
				  .orElseThrow(()-> new CategoryHandlingException("Category Id with Id"+catId+" Not Found!!!"));
		  List<Product> products = productRepo.findAllByCategory(category);
		return products;
	}

	@Override
	public List<Product> findProductsBySellerId(long sellerId) {
		Seller seller = sellerRepo.findById(sellerId)
				  .orElseThrow(()-> new ResourceNotFoundException("Seller with Id"+sellerId+" Not Found!!!"));
		  List<Product> products = productRepo.findAllBySeller(seller);
		return products;
	}

	
	
	

}
