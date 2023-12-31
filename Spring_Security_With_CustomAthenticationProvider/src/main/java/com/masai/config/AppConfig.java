package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

	/*
	 * HERE WE CREATE OUR OWN SECURITY CHAIN FILTER THAT AUTHENTICATES THE USER
	 * MEANS HERE WE CUSTOMIZE THE CONFIGURATION AND ALSO HERE WE USE @Bean
	 * ANNOTATION SO IT'S SHOULD REGISTOR WITH THE SPRING CONTAINER
	 */
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

		/*
		 * HERE OUR ALL THE REQUEST IS AUTHORISED
		 */
		http.authorizeHttpRequests()
				/*
				 * HERE WE GIVE THAT PARTICULAR END POINT(APIs) TO ACCESS ANYONE MEANS THIS API
				 * BY AUTHORISED CLIENTS ALSO AND UNAUTHORISED CLIENT ALSO WHITE LISTING THIS
				 * API IF WE HAVE TWO END POINTS WITH SAME NAME BUT DIFFERENT GETTING METHOD SO
				 * WE HAVE GIVE THE TYPE ALSO
				 */
				.requestMatchers("/customers").permitAll()
				/*
				 * HERE WE GIVE END ALL THE POINT(APIs)[NOT INCLUDE THAT APIs WHERE WE GIVE
				 * .permillAll() ] TO ACCESS BY AUTHORISED CLIENTS ONLY
				 */
				.anyRequest().authenticated()
				/*
				 * SOME EXTRA INFORMATION OR SECURITY FEATURES
				 */
				.and()
				/*
				 * HERE WE DISABLE THE csrf (Cross-Site Request Forgery) IF WE EBBALED THE
				 * SPRING SECURITY FEATURE IN OUR APPLICATION IT WILL STOP ANY KIND OF POST
				 * REQUEST AND PUT REQUEST WHICH WILL SHARE SOME DATA BY DEFUALT IT IS ENBLED IN
				 * THE SPRING SECURITY BUT WE HAVE TO DISABLED THIS
				 */
				.csrf().disable()
				/*
				 * THIS IS BASICALLY USED FOR WEB BROSWER WHERE WE CAN SEE THE LOGIN PAGE WHICH
				 * IS AUTOMATICALLY CREATED BY SPRING SECURITY
				 */
				.formLogin().and()
				/*
				 * THIS IS BASICALLY USE FOR POSTMEN AND SOME JAVASCRIPT
				 */
				.httpBasic();

		/*
		 * THIS STATEMENT WILL RETURN THE SECURITY CHAIN OBJECT
		 */
		return http.build();

	}

	/*
	 * HERE THIS METHOD IS RESponSiBLe fOR RETURNING THE PasswordEncoder OBJECT
	 * WHERE WE CONVERTED THE USER PASSWORD INTO Base64 Encoded VERSION AND ALSO
	 * HERE WE USE @Bean ANNOTATION SO IT'S SHOULD REGISTOR WITH THE SPRING
	 * CONTAINER
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
