package com.bursary.bursary.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

	@GetMapping(value = "/")
	public String root() {
		return "login";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/access-denied")
	public String accessDenied() {
		
		return "access-denied";
	}
}