package com.mfpe.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mfpe.model.AuditType;
import com.mfpe.model.Question;

@FeignClient(value = "auditchecklist", url = "localhost:8200")
public interface AuditCheckListFeign {
	
	@GetMapping("/AuditCheckListQuestions")
	public List<Question> auditCheckListQuestions(@RequestBody AuditType auditType);
	
}
