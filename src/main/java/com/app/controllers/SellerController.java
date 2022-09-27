package com.app.controllers;
import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.ApiResponse;
import com.app.dto.SellerDto;
import com.app.dto.SellerLoginRequest;
import com.app.dto.SellerSignupRequest;
import com.app.entities.Seller;
import com.app.service.ISellerService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/sellers")
public class SellerController {

	  @Autowired
	  private ISellerService sellerService;
	  
	  @Autowired
	   private ModelMapper modelMapper;
	
	//register new seller 
		@PostMapping("/signup")
		public ResponseEntity<?>registerSeller(@Valid @RequestBody  SellerSignupRequest request){
			 boolean findUserByEmail = sellerService.findSellerByEmail(request.getEmail());
			 if(!findUserByEmail) {
			  return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.registerNewSeller(request));
			}
			 return new ResponseEntity<ApiResponse>(new ApiResponse("Duplicate Seller Entry Email Id Already Exist!!!!"),HttpStatus.BAD_REQUEST);
		}
	
		//authenticate seller and login
		@PostMapping("/login")
		public ResponseEntity<?> authenticateSeller(@RequestBody SellerLoginRequest request){
			return ResponseEntity.ok(sellerService.login(request));
		}
		
		
		//update seller details by id
		@PutMapping("/update/{sellerId}")
		public ResponseEntity<?>updateSeller(@Valid @RequestBody  SellerDto sellerDto,@PathVariable Long sellerId){
			return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.updateSeller(sellerDto,sellerId));
		}
		
		//delete seller by id
	
		@DeleteMapping("/delete/{sellerId}")
		public ResponseEntity<?>deleteSeller(@PathVariable Long sellerId){
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(sellerService.deleteSeller(sellerId));
		}
		
		//get all users 
	
		@GetMapping("")
		public ResponseEntity<List<SellerDto>>getAllSellers(){
			return ResponseEntity.ok(sellerService.getAllSellers());
		}
		//get single seller by id
		@GetMapping("/{sellerId}")
		public ResponseEntity<?> getSellerById(@PathVariable Long sellerId){
			return ResponseEntity.ok(sellerService.getSellerById(sellerId));
		}
		
		
//				@PutMapping("/update/{sellerId}")
//				public ResponseEntity<?>updateSeller(@Valid @RequestBody  SellerSignupRequest request,@PathVariable long sellerId){
//					    Seller seller = sellerService.findSellerById(sellerId);
//					     seller.setName(request.getName());
//					     seller.setAddress(request.getAddress());
//					     seller.setCity(request.getCity());
//					     seller.setEmail(request.getEmail());
//					     seller.setGstin(request.getGstin());
//					     seller.setPassword(request.getPassword());
//					     seller.setPhone(request.getPhone());
//					     seller.setPin(request.getPin());
//					     seller.setRevenue(request.getRevenue());
//					  return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.registerNewSeller(modelMapper.map(seller,SellerSignupRequest.class )));
//				}
		
}
