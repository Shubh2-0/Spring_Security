package com.masai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/hello")
	public String sayHello() {

		return "Welcome to Spring Security";
	}

	@GetMapping("/learn")
	public String sayHello2() {

		return "I am learning Spring Security";
	}
}
