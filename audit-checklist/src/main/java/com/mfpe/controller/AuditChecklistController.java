package com.mfpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.model.AuditType;
import com.mfpe.model.Question;
import com.mfpe.service.QuestionService;

@RestController
public class AuditChecklistController {
	
	@Autowired
	QuestionService questionService;
	
	// Endpoint for retrieving the questions from the DB 
	@GetMapping("/AuditCheckListQuestions")
	public List<Question> auditCheckListQuestions(@RequestBody AuditType auditType){
		return questionService.getQuestionsByAuditType(auditType.getAuditType());
	}
	
	// Endpoint to check if the microservice is active
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Audit Checklist Microservice is Active";
	}
}
