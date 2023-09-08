package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {

		return customerRepository.save(customer);

	}

	@Override
	public Customer getCustomerByEmail(String email) throws CustomerException {

		/*
		 * HERE WE USE FUNCTIONAL WHY TO RETURN THE CUSTOMER OBJECT IT'S POSSIBLE BY THE
		 * HELP OF Optional CLASS IF THE OPTIONAL IS NOT EMPTY THAN IT RETURN THE
		 * CUSTOMER OBJECT OTHER WISE IT THROW THE CustomerException IT ISE VERY SIMPLE
		 * AND EASY
		 * 
		 */
		return customerRepository.findByEmail(email)
				.orElseThrow(() -> new CustomerException("Customer not found by this email : " + email));

	}

	@Override
	public List<Customer> getAllCustomer() throws CustomerException {

		List<Customer> customers = customerRepository.findAll();

		if (customers.isEmpty())
			throw new CustomerException("no customer found");

		return customers;

	}

	@Override
	public List<Customer> getCustomerByAddress(String address) throws CustomerException {

		return customerRepository.findByAddress(address)
				.orElseThrow(() -> new CustomerException("No customer found we that address :" + address));

	}

}
