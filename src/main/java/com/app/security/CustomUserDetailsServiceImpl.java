//package com.app.security;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.app.dao.UserRepository;
//import com.app.entities.User;
//
//@Service
//@Transactional
//public class CustomUserDetailsServiceImpl  implements UserDetailsService{
//	
//	@Autowired
//	private UserRepository userRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		//search in db for existing user by user email
//		User authenticatedUser = userRepo.findByEmail(email)
//				.orElseThrow(() -> new UsernameNotFoundException("User With Email "+email+" Not Found!!!"));
//		
//		return new CustomUserDetails(authenticatedUser) ;
//	}
//
//}
