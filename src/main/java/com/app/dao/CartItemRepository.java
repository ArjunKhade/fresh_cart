package com.app.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entities.Cart;
import com.app.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	List<CartItem> findAllByCart(Cart cart);
}
