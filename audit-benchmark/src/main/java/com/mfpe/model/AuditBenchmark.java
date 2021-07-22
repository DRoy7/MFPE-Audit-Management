package com.mfpe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditBenchmark {
	
	private String auditType;
	private int benchmarkNoAnswers;
}
