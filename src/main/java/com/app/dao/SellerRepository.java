package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long> {
	
	  //add user authentication method : finder method
       Optional<Seller>findByEmailAndPassword(String email,String pass);
       //finder method to find user by email
       Optional<Seller> findByEmail(String email);
}
