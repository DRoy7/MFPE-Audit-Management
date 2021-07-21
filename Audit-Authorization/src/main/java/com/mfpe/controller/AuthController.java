package com.mfpe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck(){
		return new ResponseEntity<String>("Audit-Authorization MS Running Fine!!", HttpStatus.OK);
	}
}
