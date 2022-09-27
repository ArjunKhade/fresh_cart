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
     
   //create a new user with password encoding
    // ApiResponse  registerNewUserWithPasswordEncoding(UserSignupRequest userDto);
     
     //login user
     UserLoginResponse login(UserLoginRequest userDto);
     
     //get all users
     List<UserDto> getAllUsers();
     
     //update user details
     UserDto updateUser(UserDto user,Long userId);
     
     //get user by id
     UserDto getUserById(Long userId);
     
     //delete user by id
     ApiResponse deleteUser(Long userId);
     
   //duplicate user entry
     boolean findUserByEmail(String email);

	User findUserById(Long userId);
     
    
}
