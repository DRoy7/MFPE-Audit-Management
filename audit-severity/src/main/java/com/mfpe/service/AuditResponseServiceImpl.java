package com.mfpe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mfpe.model.AuditBenchmark;
import com.mfpe.model.AuditResponse;
import com.mfpe.model.Question;

@Service
public class AuditResponseServiceImpl implements AuditResponseService{
	
	public List<AuditResponse> getAuditResponses(List<AuditBenchmark> benchmarkList,List<Question> questionListInternal,List<Question> questionListSox) {
		
		List<AuditResponse> auditResponeList = new ArrayList<>(2);
		/*
		 * From the benchmark microservice list here we
		 * count the number of no's for each audit type 
		 */
		int acceptableNoInternal = 0 ,acceptableNoSox = 0;
		for(AuditBenchmark ab : benchmarkList) {
			if(ab.getAuditType().equalsIgnoreCase("Internal")) {
				acceptableNoInternal = ab.getBenchmarkNoAnswers();
			}else {
				acceptableNoSox = ab.getBenchmarkNoAnswers();
			}
		}		
		auditResponeList.set(0, createAuditResponse(acceptableNoInternal,questionListInternal));
		auditResponeList.set(1, createAuditResponse(acceptableNoSox, questionListSox));
					
		return auditResponeList;
			
	}
	//This method is to check the audit responses with the audit type
	private AuditResponse createAuditResponse(int acceptableNo,List<Question> questions) {
		
		String auditType = questions.get(0).getAuditType();	
		int actualNo = countNos(questions);
		AuditResponse auditResponse = new AuditResponse();
		/* Here we check actual condition of the severity microservice
		*  Determines the project execution status and the remediation duration detail
		*/
		if(actualNo <= acceptableNo && auditType.equalsIgnoreCase("Internal")) {
			auditResponse.setAuditId((int) Math.random());
			auditResponse.setProjectExecutionStatus("GREEN");
			auditResponse.setRemedialActionDuration("No action needed");
		}
		else if(actualNo > acceptableNo && auditType.equalsIgnoreCase("Internal")) {
			auditResponse.setAuditId((int) Math.random());
			auditResponse.setProjectExecutionStatus("RED");
			auditResponse.setRemedialActionDuration("Action to be taken in 2 weeks");
		}
		else if(actualNo <= acceptableNo && auditType.equalsIgnoreCase("Sox")) {
			auditResponse.setAuditId((int) Math.random());
			auditResponse.setProjectExecutionStatus("GREEN");
			auditResponse.setRemedialActionDuration("No action needed");
		}
		else{
			auditResponse.setAuditId((int) Math.random());
			auditResponse.setProjectExecutionStatus("RED");
			auditResponse.setRemedialActionDuration("Action to be taken in 1 week");
		}
		
		
		return auditResponse;
	}
	
	//This  method is to count the number of No's
	private int countNos(List<Question> questions) {
		
		int count = 0;
		for(Question q:questions) {
			if(q.getResponse().equalsIgnoreCase("No")) {
				count++;
			}
		}
		return count;		
	}	
	
}
