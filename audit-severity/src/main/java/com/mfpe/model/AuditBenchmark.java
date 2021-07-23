package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AuditBenchmark {
	
	private int benchmarkId;
	private String auditType;
	private int benchmarkNoAnswers;
	
}
