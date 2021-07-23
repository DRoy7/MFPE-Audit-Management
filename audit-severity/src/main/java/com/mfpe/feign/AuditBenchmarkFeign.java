package com.mfpe.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mfpe.model.AuditBenchmark;

@FeignClient(value = "auditbenchmark", url = "localhost:8250")
public interface AuditBenchmarkFeign {
	
	@GetMapping("/AuditBenchmark")
	public List<AuditBenchmark> getAuditBenchmark(); 
	
}
