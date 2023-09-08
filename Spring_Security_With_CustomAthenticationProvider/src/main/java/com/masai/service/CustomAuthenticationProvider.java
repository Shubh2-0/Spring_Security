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

/*
 * HERE WE HAVE TO MATCH THE PASSWORD AND EMAIL FOR CLIENT
 * AND WE NEED TO LOAD THE USER AND WE HAVE TO RETURN 
 * THE Authentication Object 
 * BY DEFUALT DAOAuthenticationProvider IS 
 * DO THIS PROCESS
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * HERE THIS METHOD WILL TAKE THE Authentication Object WHICH HAVING THE
	 * Username AND Password OF THE USER AND IT WILL RETURN THE Authentication
	 * Object WHICH HAVING THE Username AND Password AND One Principal Object THAT
	 * SHOW THE USER IS AUTHENTICATE
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		Optional<Customer> opt = customerRepository.findByEmail(username);

		if (opt.isEmpty())
			throw new BadCredentialsException("No user found with this username");

		else {

			/*
			 * AT THIS POINT THE USERNAME THAT THE USER IS PROVIDED IS PRESENT IN OUR DATBASE
			 * NOW WE HAVE TO CHECK THIER PASSWORD THAT THE PASSWORD IS SAME OR NOT
			 */
			Customer customer = opt.get();

			if (passwordEncoder.matches(password, customer.getPassword())) {

				List<GrantedAuthority> authorities = new ArrayList<>();

				return new UsernamePasswordAuthenticationToken(username, password, authorities);

			} 
			else
				throw new BadCredentialsException("Invalid Password");

		}

	}

	// to implement this method we can take the support of DAOAP implementation class
		@Override
		public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

		}

}
