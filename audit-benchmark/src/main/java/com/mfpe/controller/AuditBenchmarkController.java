package com.mfpe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.model.AuditBenchmark;

@RestController
public class AuditBenchmarkController {
	
	@GetMapping("/AuditBenchmark")
	public List<AuditBenchmark> getAuditBenchmark() {
		List<AuditBenchmark> benchmarkList = new ArrayList<>();
		benchmarkList.add(new AuditBenchmark("Internal",3));
		benchmarkList.add(new AuditBenchmark("SOX",1));
		
		return benchmarkList;
	}
	
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Audit Benchmark Microservice is Active";
	}
	
}
