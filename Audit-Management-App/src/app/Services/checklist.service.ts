import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Question } from '../CheckList/question';


@Injectable({
  providedIn: 'root'
})
export class ChecklistService {

  readonly APIUrl="http://localhost:8200/checklist";
  private _responses: Question[] = [];

  public get responses(): Question[] {
    return this._responses;
  }

  getQuestionsFromMS(type: string) : Observable<Question[]> {
    return this.http.post<Question[]>(this.APIUrl+'/AuditCheckListQuestions',{ 'auditType':type } );
    // subscribe((data)=>this.responses=data);
    // console.log(this.responses);
    // return this.responses;
  }

  connectioncheck() : Observable<any> {
    return this.http.get<any>(this.APIUrl+'/health-check',{responseType:'text' as 'json'});
  }

  getResponse(responses: Question[]) : void {
    console.log("From checklist service GET Response");
    console.log(this._responses);
    this._responses = responses;
    //this.sendResponse();
  }
  
  sendResponse() : Question[] {
    console.log("From checklist service send Response");
    console.log(this._responses);
    return this._responses;
  }
  
  validated(questions: Question[]) {
    console.log("Inside checklist service question validation");
    for(let q of questions){
      if(q.response!="YES" && q.response!="NO"){
        return false;
      }
    }
    this._responses=questions;
    return true;
  }
  
  getAuditType() : string{
    return this._responses[0].auditType;
  }

  constructor(private http:HttpClient) { }

}
