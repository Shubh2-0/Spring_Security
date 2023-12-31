package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

/*
 * SO HERE WE CREATED OUR OWN UserDetailsService CLASS 
 * WHICH ARE RESPONSIBLE NFOR Authorized OUR USERS
 * BY DEFUALT IT USES InMemoryDeatailsService 
 * FOR AUTHENTICATION OUR USERS
 * 
 * 
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Customer> optional = customerRepository.findByEmail(username);

		if (optional.isPresent()) {

			Customer customer = optional.get();

			/*
			 * HERE WE DECLARED SOME AUTHORITY THAT BELONGS TO THAT USER LIKE ROLE BASED
			 * PERMISSIONS, FUNTIONALITY AND SO ON
			 */
			List<GrantedAuthority> authorities = new ArrayList<>();

			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(customer.getRole());
			
			authorities.add(simpleGrantedAuthority);
			
			return new User(customer.getEmail(), customer.getPassword(), authorities);

		} else

			throw new BadCredentialsException("User not found with this email :" + username);

	}

}
