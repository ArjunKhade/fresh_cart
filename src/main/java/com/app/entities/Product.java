package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "seller")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product  extends BaseEntity{

	@Column(name = "product_name", length = 50)
	 private String productName;
	 
	@Column(name = "product_description", length = 500)
	 private String productDescription;
	 
	@Column(name="quantity")
	 private int quantity;
	 
	@Column(name="product_price")
	 private double productPrice;
	 
	@Column(name="product_discount")
	 private double productDiscount;
	 
	@Column(name="product_rating")
	 private int productRating;
	 
	@Column(name="product_image", length = 100)
	 private String productImage;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	 private Category category;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Seller seller;
	
	
}
