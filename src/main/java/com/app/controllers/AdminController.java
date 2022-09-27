package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CategoryDto;
import com.app.dto.ProductDto;
import com.app.dto.SellerDto;
import com.app.dto.UserDto;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.service.ICategoryService;
import com.app.service.IProductService;
import com.app.service.ISellerService;
import com.app.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IProductService productService;

	@Autowired
	private ISellerService sellerService;

	// get all users
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	// get all sellers
	@GetMapping("/sellers")
	public ResponseEntity<List<SellerDto>> getAllSellers() {
		return ResponseEntity.ok(sellerService.getAllSellers());
	}

	// update user details by id
	@PutMapping("/user/update/{userId}")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long userId) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(userDto, userId));
	}

	// delete user by id
	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.deleteUser(userId));
	}

	// get single user by id
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId) {
		return ResponseEntity.ok(userService.getUserById(userId));
	}

	// update seller details by id
	@PutMapping("/seller/update/{sellerId}")
	public ResponseEntity<?> updateSeller(@Valid @RequestBody SellerDto sellerDto, @PathVariable Long sellerId) {
		return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.updateSeller(sellerDto, sellerId));
	}

	// delete seller by id
	@DeleteMapping("/seller/delete/{sellerId}")
	public ResponseEntity<?> deleteSeller(@PathVariable Long sellerId) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(sellerService.deleteSeller(sellerId));
	}

	// get single seller by id
	@GetMapping("/seller/{sellerId}")
	public ResponseEntity<?> getSellerById(@PathVariable Long sellerId) {
		return ResponseEntity.ok(sellerService.getSellerById(sellerId));
	}
	
	 @GetMapping("/categories")   
	   public ResponseEntity<?> findAllCategory(){
		List<Category> categoryList = categoryService.getAllCategory();
		return ResponseEntity.ok(categoryList);
	}
	
	 @GetMapping("/categories/id/{id}")
		public ResponseEntity<?> findByCategoryId(@PathVariable("id") long  categoryId) {
			Category newCategory=categoryService.findByCategoryId(categoryId);
			return ResponseEntity.ok(newCategory);
		}
	 
	 @DeleteMapping("/categories/id/{id}")
		public ResponseEntity<?> deleteCategoryById(@PathVariable("id") long id) {
			Category category = categoryService.findByCategoryId(id);
		 ApiResponse response = categoryService.deleteByCategoryId(category.getId());
		   return  ResponseEntity.status(HttpStatus.OK).body(response);
		}
	 
	 @PutMapping("/categories/name/{name}")
		public ResponseEntity<?> updateCategoryByName(CategoryDto catDto, @PathVariable("name") String name) {
			Category category = categoryService.findByCategoryName(name);
			category.setCategoryName(catDto.getCategoryName());
			category.setCategoryDescription(catDto.getCategoryDescription());
			categoryService.saveCategoryWithImage(category, catDto.getCategoryImage());
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Category With Id "+category.getId()+"Updated Successfully!!!"));
		}
	 
	 
	// rest point to get all the products
		@GetMapping("/products")
		public ResponseEntity<?>getAllProducts(){
			List<Product>productList = productService.getAllProduct();
			return ResponseEntity.ok(productList);
		}
		
		//get the product by id
		@GetMapping("products/id/{id}")
		public ResponseEntity<?> findProductById(@PathVariable("id")long  id) {
			Product product = productService.findByProductId(id);
			return ResponseEntity.ok(product);
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
		
		@DeleteMapping("products/id/{id}")
		public ApiResponse deleteProductById(@PathVariable("id") long id) {
		    ApiResponse response = productService.deleteByProductId(id);
		    return response;
		}
		

}
