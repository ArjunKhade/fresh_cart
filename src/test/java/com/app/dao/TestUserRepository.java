package com.app.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.entities.User;

@DataJpaTest//to scan dao component 
@AutoConfigureTestDatabase(replace = Replace.NONE)//to use our def db not (h2)
class TestUserRepository {
	
	@Autowired
	private UserRepository userRepo;

	@Test
	//@Rollback(false)//to tell container do changes in db 
	void testCreateUser() {
		System.out.println(userRepo.save(new User()));
	}
	
	@Test
	//@Rollback(false)//to tell container do changes in db 
	void testDeleteUser() {
		userRepo.delete(new User());
	}
	
	@Test
	//@Rollback(false)//to tell container do changes in db 
	void findUserByEmailtest() {
		userRepo.findByEmail("ak@gmail.com").orElseThrow(()-> new RuntimeException("User Not Found!!"));
	}
	
	@Test
	//@Rollback(false)//to tell container do changes in db 
	void test() {
		userRepo.existsById((long) 1);
	}
	
	
	

}
