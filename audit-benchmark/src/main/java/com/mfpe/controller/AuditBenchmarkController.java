package com.mfpe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.model.AuditBenchmark;
import com.mfpe.service.AuditBenchmarkService;
import com.mfpe.service.AuthorizationService;

@RestController
@RequestMapping("/benchmark")
public class AuditBenchmarkController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private AuditBenchmarkService auditBenchmarkService;
	
	
	// Endpoint to retrieve the Audit Benchmark details
	@GetMapping("/AuditBenchmark")
	public List<AuditBenchmark> getAuditBenchmark(@RequestHeader("Authorization") String jwt) {
		List<AuditBenchmark> auditBenchmarks = new ArrayList<>();
		
		// checking if the jwt is valid or not
		if(jwt.length()>0 && authorizationService.validateJwt(jwt.substring(7))) {			
			auditBenchmarks = auditBenchmarkService.getAuditBenchmarkList();
		}
		return auditBenchmarks;
	}
	
	// Endpoint to check if the microservice is live
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Audit Benchmark Microservice is Active";
	}
	
}
