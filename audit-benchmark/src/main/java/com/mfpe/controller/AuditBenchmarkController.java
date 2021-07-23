package com.mfpe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.model.AuditBenchmark;
import com.mfpe.service.AuditBenchmarkService;

@RestController
public class AuditBenchmarkController {
	
	@Autowired
	AuditBenchmarkService auditBenchmarkService;
	
	// Endpoint to retrieve the Audit Benchmark details
	@GetMapping("/AuditBenchmark")
	public List<AuditBenchmark> getAuditBenchmarkFromRepo() {
		return auditBenchmarkService.getAuditBenchmarkList();
	}
	
	// Endpoint to check if the microservice is live
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Audit Benchmark Microservice is Active";
	}
	
}
