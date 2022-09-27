package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CartItemRepository;
import com.app.dao.CartRepository;
import com.app.dto.ApiResponse;
import com.app.dto.CartDto;
import com.app.dto.CartItemDto;
import com.app.entities.Cart;
import com.app.entities.CartItem;
import com.app.entities.User;
import com.app.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class CartServiceImpl implements ICartService{
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public Cart getCartByCartId(long id) {
		    Cart cart = cartRepo.findById(id)
		    		.orElseThrow(()-> new ResourceNotFoundException("Cart with Id "+id+" Not Found!!"));
		return cart;
	}

	@Override
	public Cart getCartBycustomerId(long id) {
		User user = userService.findUserById(id);
		Cart cart = user.getCart();
	    return cart;
	}

	@Override
	public ApiResponse saveCart(CartDto cartDto) {
		User user = userService.findUserById(cartDto.getCustomerId());
		Cart cart = modelMapper.map(cartDto, Cart.class);
		 cart.setUser(user);
		Cart savedCart = cartRepo.save(cart);
		return new ApiResponse("Cart With Id "+savedCart.getId()+" Saved Successfully!!!");
	}

	@Override
	public Cart addItemInCart(long userId, CartItemDto cartItemDto) {
		   User user = userService.findUserById(userId);
		   Cart cart = user.getCart();
		   CartItem cartItem = new CartItem();
		   
		    cartItem.setCart(cart);
		    cartItem.setProduct(productService.findByProductId(cartItemDto.getProductId()));
		    cartItem.setProductQuantity(cartItemDto.getProductQuantity());
		    List<CartItem> cartItems = cart.getCartItems();
		                cartItems.add(cartItem);
		   cart.setCartItems(cartItems);
		   
		  
		   Cart savedCart = cartRepo.save(cart);
		   
		   
		   return savedCart;
	}

	@Override
	public Cart removeItemInCart(long userId, CartItemDto cartItemDto) {
		 User user = userService.findUserById(userId);
		 Cart cart = user.getCart();
		 
		 cart.getCartItems().forEach(item -> {
			 if(item.getProduct().getId()==cartItemDto.getProductId()) {
				 cartItemRepo.deleteById(item.getId());
			 }
		 });
		 
		 cart.getCartItems().removeIf(item -> (item.getProduct().getId()==cartItemDto.getProductId()));
		 Cart updatedCart = cartRepo.save(cart);
		 
		return updatedCart;
	}

}
