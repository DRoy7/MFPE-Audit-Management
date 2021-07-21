package com.mfpe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")	//Context Root
public class AuthController {
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck(){	// for Health check [PERMITTED FOR ALL]
		return new ResponseEntity<String>("Audit-Authorization MS Running Fine!!", HttpStatus.OK);
	}
	
	@GetMapping(path = {"/home", "/"})
	public ResponseEntity<String> home(){	// for Health check [Authenticated]
		return new ResponseEntity<String>("Home!!", HttpStatus.OK);
	}
	
}
