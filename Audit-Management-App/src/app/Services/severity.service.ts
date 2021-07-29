import { SecurityService } from './security.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ChecklistService } from './checklist.service';
import { Question } from '../CheckList/question';
import { AuditResponse } from '../Models/AuditResponse';
import { Observable } from 'rxjs';
import { DatePipe } from '@angular/common';
@Injectable({
  providedIn: 'root'
})
export class SeverityService {
  constructor(
    private http:HttpClient,
    private checklistService:ChecklistService,
    private securityService : SecurityService,
    private datePipe: DatePipe)
   {}
  setAuditResponse(data: AuditResponse) {
    throw new Error('Method not implemented.');
  }

  public auditHealthCheck(){
    return this.http.get("http://localhost:8300/severity/health-check",{ responseType : 'text'});
  }

  public getResponses() : Question[]{
    console.log("Inside severity service getResponse");
    return this.checklistService.sendResponse();
  }

  public executionStatus() : Observable<AuditResponse> {
    console.log("Inside execution status");
    return this.http.post<AuditResponse>("http://localhost:8300/severity/ProjectExecutionStatus",
      {
        "projectName" : this.securityService.getProjectDetails().ProjectName,
        "managerName": this.securityService.getProjectDetails().Name,
        "auditDetail":{
          "auditType":this.checklistService.getAuditType(),
          "auditDate":this.datePipe.transform(new Date(),"yyyy-MM-dd"),
          "auditQuestions":this.getResponses()
        }
      }
    );
  }

}
