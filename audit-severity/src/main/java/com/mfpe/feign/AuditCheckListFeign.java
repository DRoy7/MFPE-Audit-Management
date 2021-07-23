package com.mfpe.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mfpe.model.AuditType;
import com.mfpe.model.Question;

@FeignClient(url = "localhost:8200/checklist", name="auditChecklist")
public interface AuditCheckListFeign {
	
	@RequestMapping(value = "/AuditCheckListQuestions", method = RequestMethod.POST )
	public List<Question> auditCheckListQuestions(@RequestHeader("Authorization") String jwt, @RequestBody AuditType auditType);
	
}
