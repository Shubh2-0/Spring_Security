package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
	private CustomerRepository cRepo;

	@Autowired
	private PasswordEncoder pEncoder;

	@Override
public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		
		System.out.println(username);
		System.out.println(pwd);

		Optional<Customer> opt = cRepo.findByEmail(username);

		if (!opt.isPresent())
			throw new BadCredentialsException("No User registerd with this details");
		else {

			Customer customer= opt.get();
			
			if (pEncoder.matches(pwd, customer.getPassword())) {

		List<GrantedAuthority> authorities = new ArrayList<>();
		//authorities.add(new SimpleGrantedAuthority(customer.getRole()));

		return new UsernamePasswordAuthenticationToken(username, pwd, authorities);

			} else
				throw new BadCredentialsException("Invalid Password");

		}

	}

	// to implement this method we can take the support of DAOAP implementaiotn class
	@Override
	public boolean supports(Class<?> authentication) {

	return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

	}

}

