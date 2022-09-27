package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class SellerLoginRequest {
	
     private String email;
     
     private String password;
}
