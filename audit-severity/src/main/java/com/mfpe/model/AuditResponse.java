package com.mfpe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity
@Table(name="audit_response")
public class AuditResponse {
	
	@Id
	@GeneratedValue
	private int auditId;
	private String managerName;
	private String projectName;
	private String projectExecutionStatus;
	private String remedialActionDuration;
	
}
