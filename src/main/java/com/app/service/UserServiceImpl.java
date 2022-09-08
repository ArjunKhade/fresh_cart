package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.dto.ApiResponse;
import com.app.dto.UserDto;
import com.app.dto.UserLoginRequest;
import com.app.dto.UserLoginResponse;
import com.app.dto.UserSignupRequest;
import com.app.entities.User;
import com.app.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public ApiResponse registerNewUser(UserSignupRequest userDto) {
		 User transientUser = modelMapper.map(userDto, User.class);
		 User persistentUser = userRepo.save(transientUser);
		return new ApiResponse("User registered with ID: "+persistentUser.getId()+" Successfully!");
	}

	@Override
	public UserLoginResponse login(UserLoginRequest request) {
		  User user = userRepo.findByEmailAndPassword(request.getEmail(),request.getPassword())
				            .orElseThrow(() -> new ResourceNotFoundException("Bad Credentials!!"));
		  UserLoginResponse resp = modelMapper.map(user, UserLoginResponse.class);
		return resp;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(UserDto user, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
