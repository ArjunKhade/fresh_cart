package com.app.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class SellerDto  extends BaseDto  {

	private String name;

	
	private String email;

	
	private String password;

	
	private String phone;

	
	private String city;

	
	private String pin;

	
	private String address;

	
	 private String gstin;
	
	
	 private double revenue;
	
	
}
