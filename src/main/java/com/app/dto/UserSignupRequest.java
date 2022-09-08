package com.app.dto;

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
public class UserSignupRequest extends BaseDto {
	
	//add validation rules 
	private String name;
	
	private String email;
	
	private String password;
	
	private long phone;
	
	private String city;
	
	private int pin;
	
	private String address;
	
}
