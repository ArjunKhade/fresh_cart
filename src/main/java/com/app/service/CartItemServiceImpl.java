package com.app.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CartItemRepository;
import com.app.dto.ApiResponse;
import com.app.entities.Cart;
import com.app.entities.CartItem;
import com.app.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class CartItemServiceImpl implements ICartItemService {
	
	@Autowired
	private CartItemRepository cartItemRepo;

	@Override
	public ApiResponse addItemInCart(CartItem cartItem) {
		CartItem savedCartItem = cartItemRepo.save(cartItem);
		return new ApiResponse("CartItem with Id "+savedCartItem.getId()+" Saved Successfully!!!!");
	}

	@Override
	public ApiResponse addItemsInCart(List<CartItem> cartItems) {
		List<CartItem> savedItems = cartItemRepo.saveAll(cartItems);
		return new ApiResponse("All the Items Saved Successfully!!!!"+savedItems.size());
	}

	@Override
	public List<CartItem> getAllItemOfCart(Cart cart) {
	        List<CartItem> cartItems = cartItemRepo.findAllByCart(cart);
	        if(cartItems.isEmpty()) {
	        	throw new ResourceNotFoundException("Cart Is Empty");
	        }
		return cartItems;
	}

	@Override
	public CartItem findByCartItemId(long id) {
		 CartItem  cartItem = cartItemRepo.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("CartItem with Id "+id+" Not Found!!!"));
		return cartItem;
	}

}
