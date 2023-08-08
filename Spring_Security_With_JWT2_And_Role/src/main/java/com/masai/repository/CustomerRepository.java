package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	/*
	 * HERE WE CREATE A METHOD WHERE WE CAN FIND THE USER BY THIER EMAIL ADDRESS AND
	 * ALSO HERE WE USE Optional CLAS FOR ACCHIEVING THE FUNCTIONAL WAY
	 */
	public Optional<Customer> findByEmail(String email);

	/*
	 * HERE WE CREATE A METHOD WHERE WE CAN FIND THE USER BY THIER ADDRESS ALSO
	 */
	public Optional<List<Customer>> findByAddress(String address);

}
