//package com.app.jwt_utils;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import com.app.security.CustomUserDetails;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//
//@Component
//@Slf4j
//public class JwtUtils {
//	
//	@Value("${SECRET_KEY}")
//	private  String jwtSecret;
//	
//	@Value("${EXP_TIMEOUT}")
//	private  int jwtExpirationMs;
//	
//	/********************************************************************/
//	//generate jwt  token//this will be invoked by rest controller after successfull authentication be authentication manager
//	public String generateJwtToken (Authentication authentication) {
//		  CustomUserDetails userPrincipal =(CustomUserDetails) authentication.getPrincipal();
//		return Jwts.builder()
//				.setSubject((userPrincipal.getUsername()))
////				.claim("user", userPrincipal.userData())
//				.setIssuedAt(new Date())
//				.setExpiration(new Date((new Date()).getTime()+jwtExpirationMs))
//				.signWith(SignatureAlgorithm.HS512, jwtSecret)
//				.compact();
//		
//	}
//	
//	/********************************************************************/
//	//get username from token // this method will be invoked by our custom filter
//	public String getUserNameFromJwtToken(String token) {
//		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
//	}
//	
//	/********************************************************************/
//	//validate jwt token // this method will be invoked by our custom filter
//	public boolean validateJwtToken(String authToken) {
//		try {
//			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//			return true;
//		}catch (Exception e) {
//			log.error("Invalid JWT : "+e.getMessage());
//		}
//		return false;
//	}
//	
//	/********************************************************************/
//	
//	
//	
//
//}
