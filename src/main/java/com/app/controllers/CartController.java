package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CartDto;
import com.app.dto.CartItemDto;
import com.app.entities.Cart;
import com.app.service.ICartService;

@RestController
@CrossOrigin
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getCartByUserId(@PathVariable("userId") long userId){
		Cart cart = cartService.getCartBycustomerId(userId);
		return ResponseEntity.ok(cart);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?> saveCart(@RequestBody CartDto cartDto){
		ApiResponse resp = cartService.saveCart(cartDto);
		return ResponseEntity.ok(resp);
	}
	
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> saveCartByUserId(@RequestBody CartItemDto cartItem,@PathVariable("userId") long userId){
		Cart savedCart = cartService.addItemInCart(userId, cartItem);
		return ResponseEntity.ok(savedCart);
	}
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateProductInCart(@PathVariable("userId") long userId, @RequestBody CartItemDto cartItemDto ) {
		Cart updateCart = cartService.addItemInCart(userId, cartItemDto);
		return ResponseEntity.ok(updateCart);
	}
	
	@PutMapping("remove/{userId}")
	public ResponseEntity<?> removeProductInCart(@PathVariable("userId") long userId, @RequestBody CartItemDto cartItemDto ) {
		Cart cart = cartService.removeItemInCart(userId,cartItemDto);
		return ResponseEntity.ok("Cart updated With Id "+cart.getId()+" !!!! Removed Item!!! With Id "+cartItemDto.getCartItemId());
	}
	
	
	
	

}
