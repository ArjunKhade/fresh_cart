//package com.app.controllers;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.dto.ApiResponse;
//import com.app.dto.AuthResp;
//import com.app.dto.UserLoginRequest;
//import com.app.dto.UserSignupRequest;
//import com.app.jwt_utils.JwtUtils;
//import com.app.service.IUserService;
//
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin
//public class SignInSignUpController {
//	
//         @Autowired
//         private JwtUtils utils;
//         
//         @Autowired
//         private AuthenticationManager manager;
//         
//         @Autowired
//         private IUserService userService;
//         
//         //register new user with password encoding
//      	@PostMapping("/signup")
//      	public ResponseEntity<?>registerUser( @Valid @RequestBody  UserSignupRequest request){
//      		System.out.println(request);
//      		 boolean findUserByEmail = userService.findUserByEmail(request.getEmail());
//      		 if(!findUserByEmail) {
//      		  return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerNewUserWithPasswordEncoding(request));
//      		}else {
//      			return new ResponseEntity<ApiResponse>(new ApiResponse("Duplicate User Entry Email Id Already Exist!!!!"),HttpStatus.BAD_REQUEST);
//     		}
//      		 
//      	}
//         
//   
//     @PostMapping("/signin")
//     public ResponseEntity<?> validateUserCreateToken(@Valid @RequestBody  UserLoginRequest request){
//    	 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword());
//    	 try {
//    		// authenticate the credentials
//    		 Authentication authenticatedDetails= manager.authenticate(authToken);
//    		// => auth succcess //this has granted auth
//    		 return ResponseEntity.ok(new AuthResp(utils.generateJwtToken(authenticatedDetails)));
//		} catch (BadCredentialsException e) {
//			System.out.println("err "+e);
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//		}
//     }
//         
//  
//     
//     
//}
