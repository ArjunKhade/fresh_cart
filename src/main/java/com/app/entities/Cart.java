package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@Setter
@Getter
@ToString(exclude = "user")
@Table(name = "cart")
public class Cart extends BaseEntity {
    
	private long customerId;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<CartItem>cartItems=new ArrayList<>();
	
	@OneToOne
	private User user;
	

}
