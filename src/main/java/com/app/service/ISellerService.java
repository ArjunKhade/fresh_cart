package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.SellerDto;
import com.app.dto.SellerLoginRequest;
import com.app.dto.SellerLoginResponse;
import com.app.dto.SellerSignupRequest;
import com.app.entities.Seller;

public interface ISellerService {
	
	//create a new Seller
     ApiResponse  registerNewSeller(SellerSignupRequest SellerDto);
     
     //login Seller
     SellerLoginResponse login(SellerLoginRequest SellerDto);
     
     //get all Sellers
     List<SellerDto> getAllSellers();
     
     //update Seller details
     SellerDto updateSeller(SellerDto Seller,Long SellerId);
     
     //get Seller by id
     SellerDto getSellerById(Long SellerId);
     
     //get Seller by id
     Seller findSellerById(Long SellerId);
     
     //delete Seller by id
     ApiResponse deleteSeller(Long SellerId);
     
   //duplicate Seller entry
     boolean findSellerByEmail(String email);
     
    
}
