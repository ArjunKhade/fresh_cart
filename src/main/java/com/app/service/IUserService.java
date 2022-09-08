package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.UserDto;
import com.app.dto.UserLoginRequest;
import com.app.dto.UserLoginResponse;
import com.app.dto.UserSignupRequest;
import com.app.entities.User;

public interface IUserService {
	
	//create a new user
     ApiResponse  registerNewUser(UserSignupRequest userDto);
     
     //login user
     UserLoginResponse login(UserLoginRequest userDto);
     
     List<User> getAllUsers();
     
     UserDto updateUser(UserDto user,Long userId);
     
     UserDto getUserById(Long userId);
     
     ApiResponse deleteUser(Long userId);
     
}
