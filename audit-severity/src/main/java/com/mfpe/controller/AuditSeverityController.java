package com.mfpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mfpe.feign.AuditBenchmarkFeign;
import com.mfpe.feign.AuditCheckListFeign;
import com.mfpe.model.AuditBenchmark;
import com.mfpe.model.AuditResponse;
import com.mfpe.model.AuditType;
import com.mfpe.model.Question;
import com.mfpe.service.AuditResponseService;

public class AuditSeverityController {
	
	@Autowired
	private AuditBenchmarkFeign auditBenchmarkFeign;
	
	@Autowired
	private AuditCheckListFeign auditCheckListFeign;
	
	@Autowired
	private AuditResponseService auditResponseService;
	
	//This is to check the microservice is working or not 
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}
	
	//This is to check the severity of the audit and it returns the execution status of the project
	@PostMapping("/ProjectExecutionStatus")
	public ResponseEntity<?> auditSeverity(){
		
		List<AuditBenchmark> benchmarkList = auditBenchmarkFeign.getAuditBenchmark();
		
		AuditType auditType = new AuditType();
		auditType.setAuditType("Internal");
		List<Question> questionListInternal = auditCheckListFeign.auditCheckListQuestions(auditType);
		auditType.setAuditType("Sox");
		List<Question> questionListSox = auditCheckListFeign.auditCheckListQuestions(auditType);
		
		List<AuditResponse> auditResponseList = auditResponseService.getAuditResponses(benchmarkList,questionListInternal,questionListSox);
		
		return new ResponseEntity<>(auditResponseList,HttpStatus.OK);
				
	}
}
