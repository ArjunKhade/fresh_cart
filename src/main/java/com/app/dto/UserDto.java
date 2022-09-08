package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class UserDto extends BaseDto{
	
	private String name;
	
	private String email;
	
	private String password;
	
	private long phone;
	
	private String city;
	
	private int pin;
	
	private String address;
}
