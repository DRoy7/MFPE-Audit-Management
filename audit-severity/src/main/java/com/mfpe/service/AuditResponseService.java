package com.mfpe.service;

import java.util.List;

import com.mfpe.model.AuditBenchmark;
import com.mfpe.model.AuditResponse;
import com.mfpe.model.Question;

public interface AuditResponseService {
	
	public List<AuditResponse> getAuditResponses(List<AuditBenchmark> benchmarkList,List<Question> questionListInternal,List<Question> questionListSox); 
		
}
