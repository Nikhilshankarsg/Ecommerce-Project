package com.nikhil.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class BasicController {
	
	@GetMapping("/hello")
	public String test() {  // method name should start with lowercase
		return "Hai";
	}
}
