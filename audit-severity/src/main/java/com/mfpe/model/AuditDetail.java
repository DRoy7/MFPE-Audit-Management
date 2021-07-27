package com.mfpe.model;

import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AuditDetail {
	
	private String auditType;
	private Date auditDate;
	private List<AuditQuestion> auditQuestions;
}
