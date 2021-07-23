package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AuditResponse {
	
	private int auditId;
	private String projectExecutionStatus;
	private String remedialActionDuration;
}
