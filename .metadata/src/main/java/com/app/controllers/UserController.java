package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.dto.UserLoginRequest;
import com.app.dto.UserSignupRequest;
import com.app.entities.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private IUserService userService;

	//register new user 
	@PostMapping("/signup")
	public ResponseEntity<?>registerUser(@Valid @RequestBody  UserSignupRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerNewUser(request));
		
	}
	
	//authenticate user and login
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody UserLoginRequest request){
		return ResponseEntity.ok(userService.login(request));
	}
	
	//update user details by id
	@PutMapping("/update/{userId}")
	public ResponseEntity<?>updateUser(@Valid @RequestBody  UserDto userDto,@PathVariable Long userId){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(userDto,userId));
	}
	
	//delete user by id
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?>deleteUser(@PathVariable Long userId){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.deleteUser(userId));
	}
	
	//get all users 
	@GetMapping("")
	public ResponseEntity<List<UserDto>>getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	//get single user by id
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId){
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
	
}
