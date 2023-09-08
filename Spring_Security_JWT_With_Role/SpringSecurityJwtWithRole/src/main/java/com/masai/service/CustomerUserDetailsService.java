package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.Authority;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<Customer> opt= customerRepository.findByEmail(username);

		if(opt.isPresent()) {
			
			
			//return new CustomerUserDetails(opt.get());
			
			Customer customer= opt.get();
			
			List<GrantedAuthority> authorities = new ArrayList<>();
		
			
			
			List<Authority> auths= customer.getAuthorities();
			
			for(Authority auth:auths) {
				SimpleGrantedAuthority sga=new SimpleGrantedAuthority(auth.getName());
				System.out.println("siga "+sga);
				authorities.add(sga);
			}
			
			System.out.println("granted authorities "+authorities);
			
			
			return new User(customer.getEmail(), customer.getPassword(), authorities);
			
			
			
		}else
			throw new BadCredentialsException("User Details not found with this username: "+username);
		
		
		
		
		
	}
	
	
//	 private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
//	        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//	        for (Authority authority : authorities) {
//	            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
//	        }
//	        return grantedAuthorities;
//	    }

}
