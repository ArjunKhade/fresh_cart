package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class SellerSignupRequest extends BaseDto {
	
	//TODO:add validation rules 
	@NotBlank(message = "first name is required")
	@Size(min = 4,message = "Username must be min of 4 characters")
	private String name;
	
	@NotBlank(message = "email is required")
	@Email(message = "invalid email format")
	private String email;
	
	@Column(length = 20)
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Password must be min 3 chars and max 20 must contain 1 digit,1 alfabet,1 special symbol")
	private String password;
	
	@NotBlank(message = "phone must be supplied")
	@Size(min = 10,max = 12,message = "phone number must be min 10 to 12 digit")
	private String phone;
	
	@NotBlank(message = "city is required")
	private String city;
	
	
	@NotBlank(message = "pin is required")
	@Size(min = 6,message = "Invalid pin")
	private String pin;
	
	@NotBlank(message = "address is required")
	private String address;
	
	@NotBlank(message = "gstin is required")
	 private String gstin;
	
	//@NotBlank(message = "revenue is required")
	@JsonIgnore
	 private double revenue;
	
	
}
