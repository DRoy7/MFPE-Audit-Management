package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Question {
	
	private int questionId;
	private String question;
	private String auditType;
	private String response;
	
}
