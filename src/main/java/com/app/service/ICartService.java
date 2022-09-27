package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.CartDto;
import com.app.dto.CartItemDto;
import com.app.entities.Cart;

public interface ICartService {

	 Cart getCartByCartId(long id);
	 
	 Cart getCartBycustomerId(long id);
	 
	 ApiResponse saveCart(CartDto cart);
	 
	 Cart addItemInCart(long userId, CartItemDto cartItemDto);
	 
	 Cart removeItemInCart(long userId, CartItemDto cartItemDto);
	 
}
