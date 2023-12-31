package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

/*
OUR RESTCONTROLLER WHERE WE CREATE
ENDPOINTS(APIs) 
 */

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/*
	 * THIS OBJECT IS RESPONSIBLE FOR CONVERTED THE USER PASSWORD INTO base64
	 * ENCODED VERSION
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/learn")
	public String testHandler() {

		return "LEARNING SPRING SECURITY";

	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException {

		customer.setRole("ROLE_" + customer.getRole().toUpperCase());

//		HERE WE CHANGE THE NORMAL USER PASSWORD INTO base64 encoded VERSION
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));

		Customer registorCustomer = customerService.addCustomer(customer);

		return new ResponseEntity<Customer>(registorCustomer, HttpStatus.ACCEPTED);

	}

	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerbyEmailHandler(@PathVariable("email") String email)
			throws CustomerException {

		return new ResponseEntity<Customer>(customerService.getCustomerByEmail(email), HttpStatus.ACCEPTED);

	}

	@GetMapping("/customers/all")
	public ResponseEntity<List<Customer>> getAllCustomerHandler() throws CustomerException {

		return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(), HttpStatus.ACCEPTED);

	}

	@GetMapping("/customers/address/{address}")
	public ResponseEntity<List<Customer>> getAllCustomerByAddressHandler(@PathVariable("address") String address)
			throws CustomerException {

		return new ResponseEntity<List<Customer>>(customerService.getCustomerByAddress(address), HttpStatus.ACCEPTED);
	}

}
