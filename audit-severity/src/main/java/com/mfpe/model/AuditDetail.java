package com.mfpe.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AuditDetail {
	
	private String auditType;
	private Date auditDate;
	
}
