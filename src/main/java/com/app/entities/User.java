package com.app.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(exclude = { "cart" ,"orders"})
@NoArgsConstructor
public class User extends BaseEntity {
	
	@Column(length = 20)
	private String name;
	
	 // add unique constraint to email
	@Column(length = 30, unique = true)
	private String email;
	
	@Column(length = 400)
	private String password;
	
	@Column(length = 20)
	private String phone;
	
	@Column(length = 20)
	private String city;
	
	@Column(length = 20)
	private String pin;
	
	@Column(name = "address", length = 300)
	private String address;
	
	//add role 
	@Column(length = 20)
	private String role;
	
	@JsonIgnore
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@JsonIgnore
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Seller seller;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",fetch =FetchType.LAZY,cascade = CascadeType.ALL )
	private List<OrderEntity>orders;
	
	
}
