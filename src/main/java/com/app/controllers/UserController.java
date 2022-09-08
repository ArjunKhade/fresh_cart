package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserLoginRequest;
import com.app.dto.UserSignupRequest;
import com.app.entities.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	//register new user 
	@PostMapping("/signup")
	public ResponseEntity<?>registerUser(@RequestBody UserSignupRequest request){
		System.out.println("in reg user " + request);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerNewUser(request));
		
	}
	
	//authenticate user and login
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody UserLoginRequest request){
		return ResponseEntity.ok(userService.login(request));
	}
	
	
}
