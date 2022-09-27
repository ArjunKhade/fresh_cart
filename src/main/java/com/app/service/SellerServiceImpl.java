package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SellerRepository;
import com.app.dto.ApiResponse;
import com.app.dto.SellerDto;
import com.app.dto.SellerLoginRequest;
import com.app.dto.SellerLoginResponse;
import com.app.dto.SellerSignupRequest;
import com.app.entities.Seller;
import com.app.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class SellerServiceImpl implements ISellerService {
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse registerNewSeller(SellerSignupRequest SellerDto) {
		 Seller transientSeller = modelMapper.map(SellerDto, Seller.class);
		Seller savedSeller = sellerRepo.save(transientSeller);
		return new ApiResponse("Seller registered with Id  "+savedSeller.getId()+" Successfully!!!");
	}

	@Override
	public SellerLoginResponse login(SellerLoginRequest SellerDto) {
	   Seller seller = sellerRepo.findByEmailAndPassword(SellerDto.getEmail(),SellerDto.getPassword())
			      .orElseThrow(() -> new ResourceNotFoundException("Bad Credentials"));
	   SellerLoginResponse resp = modelMapper.map(seller, SellerLoginResponse.class);
		return resp;
	}

	@Override
	public List<SellerDto> getAllSellers() {
		List<Seller> sellers = sellerRepo.findAll();
		List<SellerDto> sellerDtos = sellers.stream()
				.map(seller -> modelMapper.map(seller, SellerDto.class) )
				.collect(Collectors.toList());
		return sellerDtos;
	}

	@Override
	public SellerDto updateSeller(SellerDto sellerDto, Long sellerId) {
		Seller seller  =  sellerRepo.findById(sellerId) 
				.orElseThrow(()-> new ResourceNotFoundException("Seller With Id "+sellerId+"sellerId") );
		seller.setName(sellerDto.getName());
		seller.setAddress(sellerDto.getAddress());
		seller.setEmail(sellerDto.getEmail());
		seller.setGstin(sellerDto.getGstin());
		seller.setPassword(sellerDto.getPassword());
		seller.setPhone(sellerDto.getPhone());
		seller.setCity(sellerDto.getCity());
		seller.setRevenue(sellerDto.getRevenue());
		seller.setPin(sellerDto.getPin());
		
		Seller updatedSeller = sellerRepo.save(seller);
		return modelMapper.map(updatedSeller, SellerDto.class);
	}

	@Override
	public SellerDto getSellerById(Long sellerId) {
		Seller seller  =  sellerRepo.findById(sellerId) 
				.orElseThrow(()-> new ResourceNotFoundException("Seller With Id "+sellerId+"sellerId") );
		return modelMapper.map(seller, SellerDto.class);
	}

	@Override
	public ApiResponse deleteSeller(Long sellerId) {
		Seller seller  =  sellerRepo.findById(sellerId) 
				.orElseThrow(()-> new ResourceNotFoundException("Seller With Id "+sellerId+"Not Found!!!") );
		sellerRepo.delete(seller);
		return new ApiResponse("Seller with Id "+seller.getId()+" Deleted Successfully");
	}

	@Override
	public boolean findSellerByEmail(String email) {
		Optional<Seller> seller = sellerRepo.findByEmail(email);
		   if(seller.isPresent()){
			return true;
		}
		 return false;
		
	}

	@Override
	public Seller findSellerById(Long sellerId) {
		Seller seller  =  sellerRepo.findById(sellerId) 
				.orElseThrow(()-> new ResourceNotFoundException("Seller With Id "+sellerId+"sellerId") );
		return seller;
	}

	

}
