package com.app.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.OrderRepository;
import com.app.dao.UserRepository;
import com.app.entities.OrderEntity;
import com.app.entities.Packate;
import com.app.service.IUserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private IUserService userService;
	
	
	@Autowired
	private OrderRepository orderRepo;
	
	

	@PostMapping("/order")
	public String createOrder(@RequestBody Packate order) throws Exception {
		
		int amt = order.getAmount();
		
	System.err.println(order.getCreate());
	var client = 	new RazorpayClient("rzp_test_Xgle7zv3RN4KYE","JJDFFMSeWFkUFTops8VeAisN");
		
	JSONObject ob = new JSONObject();
	  ob.put("amount", amt*100);
	  ob.put("currency", "INR");
	  ob.put("receipt", "txn_255425");
	  
	  Order orderToRazorpay = client.Orders.create(ob);
	
	    System.out.println(orderToRazorpay);
	    
	    OrderEntity orderEntity = new OrderEntity();
	    
//	    orderEntity.setAmount(orderToRazorpay.get("amount"));
//	    orderEntity.setOrderId(orderToRazorpay.get("order_id"));
//	    orderEntity.setPaymentId(null);
//	    orderEntity.setUser(userService.findUserById(order.getUserId()));
	    
	
		return orderToRazorpay.toString();
	}
}
