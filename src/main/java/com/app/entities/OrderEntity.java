package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class OrderEntity  extends BaseEntity{

	private String orderId;
	
	private String receipt;
	
	private String status;
	
	private double amount;
	
	private String paymentId;
	
	@ManyToOne
	private User user;
	

	
	
}
