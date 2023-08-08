package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@RestController
public class CustomerLoginController {

	@Autowired
	private CustomerRepository customerRepository;

	
	/*
	 * HERE WE CREATED ONE ENDPOINT FOR signIn THE USER
	 * IT WILL TAKE Authentication object
	 * IN Authentication object WE HAVE THE USERNAME AND PASSWORD OF THE USER
	 * IN WHICH WE CAN FIND THE USER BY THIER USERNAME 
	 */
	@GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerHandler(Authentication auth){
	
		System.out.println("AUTHENTICATION OBJECT :"+   auth);
	
/*		IN Authentication object WE HAVE SOME METHOD WHERE WE CAN ACCESS THE USER INFORMATION
 *      ONE OF THEM ARE getName() WHICH BASICALLY return THE USER username
 * 
 */
		Customer customer = customerRepository.findByEmail(auth.getName()).orElseThrow((() -> new BadCredentialsException("invalid email")));
	
		
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
		
	}
	
	
}
