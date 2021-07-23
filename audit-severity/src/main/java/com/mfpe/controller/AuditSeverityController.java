package com.mfpe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.feign.AuditBenchmarkFeign;
import com.mfpe.feign.AuditCheckListFeign;
import com.mfpe.model.AuditBenchmark;
import com.mfpe.model.AuditResponse;
import com.mfpe.model.AuditType;
import com.mfpe.model.Question;
import com.mfpe.service.AuditResponseService;
import com.mfpe.service.AuthorizationService;

@RestController
@RequestMapping("/severity")
public class AuditSeverityController {
	
	@Autowired
	private AuditBenchmarkFeign auditBenchmarkFeign;
	
	@Autowired
	private AuditCheckListFeign auditCheckListFeign;
	
	@Autowired
	private AuditResponseService auditResponseService;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	//This is to check the microservice is working or not 
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Audit Severity Microservice is Active", HttpStatus.OK);
	}
	
	//This is to check the severity of the audit and it returns the execution status of the project
	@PostMapping("/ProjectExecutionStatus")
	public ResponseEntity<?> auditSeverity(@RequestHeader("Authorization") String jwt){
		List<AuditResponse> auditResponseList = new ArrayList<>();
		
		// checking if the jwt is valid or not
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {	
			List<AuditBenchmark> benchmarkList = auditBenchmarkFeign.getAuditBenchmark(jwt);
			System.out.println(benchmarkList);
			AuditType auditType = new AuditType();
			auditType.setAuditType("Internal");
			List<Question> questionListInternal = auditCheckListFeign.auditCheckListQuestions(jwt, auditType);
			System.out.println(questionListInternal);
			auditType.setAuditType("SOX");
			List<Question> questionListSox = auditCheckListFeign.auditCheckListQuestions(jwt, auditType);
			System.out.println(questionListSox);
			auditResponseList = auditResponseService.getAuditResponses(benchmarkList,questionListInternal,questionListSox);
		}
//		List<AuditResponse> auditResponseList = new ArrayList<>();
		
		
		return new ResponseEntity<>(auditResponseList,HttpStatus.OK);
		
	}
}
