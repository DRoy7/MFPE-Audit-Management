package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AuditRequest {
	private String projectName;
	private String managerName;
	private String ownerName;
	private AuditDetail auditDetail;
	
}
