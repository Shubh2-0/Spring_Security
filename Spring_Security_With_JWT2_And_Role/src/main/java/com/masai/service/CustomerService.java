package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer) throws CustomerException;

	Customer getCustomerByEmail(String email) throws CustomerException;
	
	List<Customer> getAllCustomer() throws CustomerException;
	
	List<Customer> getCustomerByAddress(String address) throws CustomerException;
}
