package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	@GetMapping("/hello")
	public String hello() {
		return "Hello ";
	}
	
	@GetMapping("/home")
	public String world() {
		return "Vanakam";
	}
}
