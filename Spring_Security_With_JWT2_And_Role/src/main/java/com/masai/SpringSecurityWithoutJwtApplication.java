package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityWithoutJwtApplication {

	/*
	 * MAIN INTERFACE WHERE OUR APPLICATION IS STARTED THIS CLASS BY DEFAULT CREATED
	 * BY SPRING BOOT
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithoutJwtApplication.class, args);
	}

}
