package com.mfpe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Entity
@Table(name="audit_response")
@AllArgsConstructor
@NoArgsConstructor
public class AuditResponse {
	
	@Id
	@GeneratedValue
	private int auditId;
	private String managerName;
	private String projectName;
	private String projectExecutionStatus;
	private String remedialActionDuration;
	
}
