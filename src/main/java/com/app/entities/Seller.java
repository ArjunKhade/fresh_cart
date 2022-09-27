package com.app.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString(exclude = "productList")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seller")
public class Seller  extends BaseEntity  {
	
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

	@Column(name="gstin" , length=15)
	 private String gstin;
	
	@Column(name="revenue")
	 private double revenue;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	 private User user;
	
	@OneToMany(mappedBy = "seller" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private List<Product> productList;
}
