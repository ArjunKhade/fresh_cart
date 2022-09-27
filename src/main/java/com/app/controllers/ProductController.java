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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDto;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.Seller;
import com.app.service.ICategoryService;
import com.app.service.IProductService;
import com.app.service.ISellerService;

@CrossOrigin
@RequestMapping("/products")
@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private ISellerService sellerService;
	
	@Autowired
	   private ModelMapper modelMapper;
	
	// rest point to get all the products
	@GetMapping("")
	public ResponseEntity<?>getAllProducts(){
		List<Product>productList = productService.getAllProduct();
		return ResponseEntity.ok(productList);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<?>getAllProductsByCategoryId(@PathVariable long  categoryId){
		List<Product>productList = productService.findProductsByCategoryId(categoryId);
		return ResponseEntity.ok(productList);
	}
	
	@GetMapping("/seller/{sellerId}")
	public ResponseEntity<?>getAllProductsBySellerId(@PathVariable long  sellerId){
		List<Product>productList = productService.findProductsBySellerId(sellerId);
		return ResponseEntity.ok(productList);
	}
	
	//create product with image 
	@PostMapping("/category/{categoryId}/seller/{sellerId}")
	public ResponseEntity<?> saveProductWithImage(ProductDto productDto,@PathVariable long categoryId,@PathVariable long sellerId){
		Product savedProduct= productService.saveProductWithImage(modelMapper.map(productDto, Product.class),productDto.getProductImage(),categoryId,sellerId);
		return ResponseEntity.ok(savedProduct);
	}
	
	//get the product by id
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findProductById(@PathVariable long  id) {
		Product product = productService.findByProductId(id);
		return ResponseEntity.ok(product);
	}
	
   //get product by name
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findMultipleProductByName(@PathVariable("name")String  name) {
		List<Product> products =productService.findAllByProductName(name); 
		return ResponseEntity.ok(products);
	}

	//save product by category id
	@PostMapping("/id/{categoryId}/{sellerId}")
	public ResponseEntity<?> saveProductByCategoryId(@RequestBody Product product ,@PathVariable("sellerId") long sellerId, @PathVariable("categoryId") long categoryId) {
		Category category = categoryService.findByCategoryId(categoryId);
		Seller seller = sellerService.findSellerById(sellerId);
		product.setCategory(category);
		product.setSeller(seller);
		Product savedProduct = productService.saveProduct(product);
		return ResponseEntity.ok(savedProduct);
	}
	
	//save product by category name
	@PostMapping("/name/{categoryName}/{sellerId}")    
	public ResponseEntity<?> saveProductByCategoryName(@RequestBody Product product ,@PathVariable("sellerId") long sellerId, @PathVariable("categoryName") String categoryName) {
		Category category = categoryService.findByCategoryName(categoryName);
		Seller seller = sellerService.findSellerById(sellerId);
		product.setCategory(category);
		product.setSeller(seller);
		Product savedProduct = productService.saveProduct(product);
		return ResponseEntity.ok(savedProduct);
	}
	
	//update product with image deatails by id
	@PutMapping("/id/{id}")
	public ResponseEntity<?> updateProductById( ProductDto productDto, @PathVariable("id") long id ,@PathVariable long categoryId,@PathVariable long sellerId) {
		Product product = productService.findByProductId(id);

	   product.setProductDescription(productDto.getProductDescription());
	   product.setProductDiscount(productDto.getProductDiscount());
	   product.setProductName(productDto.getProductName());
	   product.setProductPrice(productDto.getProductPrice());
	   product.setProductRating(productDto.getProductRating());
	   product.setQuantity(productDto.getQuantity());
	
	  Product savedProduct = productService.saveProductWithImage(product,productDto.getProductImage(),categoryId,sellerId);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
	@DeleteMapping("/id/{id}")
	public ApiResponse deleteProductById(@PathVariable("id") long id) {
	    ApiResponse response = productService.deleteByProductId(id);
	    return response;
	}
	
	@DeleteMapping("/name/{name}")
	public ApiResponse deleteProductByName(@PathVariable("name") String name) {
		List<Product> products = productService.findAllByProductName(name);
		for (Product product : products) {
			long id = product.getId();
			productService.deleteByProductId(id);
		}
		return new ApiResponse("All Products With Name  "+name +"Deleted Successfully!!!");
	
	}
	
	
	
}
