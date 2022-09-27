package com.app.service;
import java.util.List;
import com.app.dto.ApiResponse;
import com.app.entities.Cart;
import com.app.entities.CartItem;
public interface ICartItemService {

	 CartItem findByCartItemId(long id);

	 ApiResponse addItemInCart(CartItem cartItem);
	 
	 ApiResponse addItemsInCart(List<CartItem> cartItems);

	  List<CartItem> getAllItemOfCart(Cart cart);
	  
}
