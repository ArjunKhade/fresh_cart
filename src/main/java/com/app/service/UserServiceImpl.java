package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.SellerRepository;
import com.app.dao.UserRepository;
import com.app.dto.ApiResponse;
import com.app.dto.UserDto;
import com.app.dto.UserLoginRequest;
import com.app.dto.UserLoginResponse;
import com.app.dto.UserSignupRequest;
import com.app.entities.Seller;
import com.app.entities.User;
import com.app.exceptions.ResourceNotFoundException;

@Service
@Transactional//we wnt to start trn at service layer and end with service layer
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Autowired
	private ModelMapper modelMapper;

//	@Autowired
//	private PasswordEncoder encoder;
	
	@Override
	public ApiResponse registerNewUser(UserSignupRequest userDto) {
		
		 User transientUser = modelMapper.map(userDto, User.class);
		 User persistentUser = userRepo.save(transientUser);

		  if(userDto.getRole().equals("seller")) {
			  Seller seller = new Seller();
			   seller.setAddress(userDto.getAddress());
			   seller.setCity(userDto.getCity());
			   seller.setEmail(userDto.getEmail());
			   seller.setPassword(userDto.getPassword());
			   seller.setName(userDto.getName());
			   seller.setPhone(userDto.getPhone());
			   seller.setPin(userDto.getPin());
               seller.setId(persistentUser.getId());
			   seller.setGstin("");
			   seller.setRevenue(0);
			   seller.setUser(transientUser);
			   sellerRepo.save(seller);
		  }
	
		    
		return new ApiResponse("User registered with ID: "+persistentUser.getId()+" Successfully!");
	}
	
	//register user with password encoding in db
//	@Override
//	public ApiResponse registerNewUserWithPasswordEncoding(UserSignupRequest userDto) {
//		System.out.println(userDto);
//		User transientUser = modelMapper.map(userDto, User.class);
//		 transientUser.setPassword(encoder.encode(userDto.getPassword()));
//		 System.out.println(transientUser);
//		 User persistentUser = userRepo.save(transientUser);
//		return  new ApiResponse("User registered with ID: "+persistentUser.getId()+" Successfully!");
//	}

	@Override
	public UserLoginResponse login(UserLoginRequest request) {
		  User user = userRepo.findByEmailAndPassword(request.getEmail(),request.getPassword())
				            .orElseThrow(() -> new ResourceNotFoundException("Bad Credentials!!"));
		  UserLoginResponse resp = modelMapper.map(user, UserLoginResponse.class);
		return resp;
	}

	@Override
	public List<UserDto> getAllUsers() {
		 List<User> users = userRepo.findAll();
		 List<UserDto> userDtos = users.stream().map(user -> userToDto(user))
				 .collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		
		User user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User with Id  "+userId+"Not found"));
		
		 user.setName(userDto.getName());
		 user.setAddress(userDto.getAddress());
		 user.setCity(userDto.getCity());
		 user.setEmail(userDto.getEmail());
		 user.setPassword(userDto.getPassword());
		 user.setPhone(userDto.getPhone());
		 user.setPin(userDto.getPin());
		 user.setRole(userDto.getRole());
		 
		 User updatedUser  = userRepo.save(user);
		 
		return userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Long userId) {
	  User user = userRepo.findById(userId)
			  .orElseThrow(() -> new ResourceNotFoundException("User with Id "+userId+" Not found"));
	 
		return userToDto(user);
	}
	
	@Override
	public User findUserById(Long userId) {
	  User user = userRepo.findById(userId)
			  .orElseThrow(() -> new ResourceNotFoundException("User with Id "+userId+" Not found"));
		return user;
	}

	@Override
	public ApiResponse deleteUser(Long userId) {
		 User user = userRepo.findById(userId)
				 .orElseThrow(()-> new ResourceNotFoundException("User with Id "+userId+" Not Found"));
		  userRepo.delete(user);
		 return  new ApiResponse("User with Id "+user.getId()+" Deleted Successfully");
	}

	public UserDto userToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
	public User dtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}
	
	

	@Override
	public boolean findUserByEmail(String email) {
		Optional<User> user = userRepo.findByEmail(email);
//		User usr = userRepo.findByEmail(email)
//				   .orElseThrow(()-> new UserHandlingException("Duplicate User Entry: "+email+" Already Exist"));
		   if(user.isPresent()){
			return true;
		}
		 return false;
	}

	

	

	

}
