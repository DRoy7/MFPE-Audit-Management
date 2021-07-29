import { SecurityService } from './../Services/security.service';
import { Component, OnInit } from '@angular/core';
import { ChecklistService } from '../Services/checklist.service';
import { Question } from './question';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checklist',
  templateUrl: './checklist.component.html',
  styleUrls: ['./checklist.component.css']
})
export class ChecklistComponent implements OnInit {
  
  questions: Question[] = [];
  connectionStatus: any = "Not connected";
  type: string = "";

  constructor(
    private checklistService:ChecklistService,private router:Router,
    private securityService : SecurityService
    ) {}

  getQuestions() : void {
    let fetch : Question[] = []; 
    this.checklistService.getQuestionsFromMS(this.type)
      // .subscribe(data => this.questions = data);
      .subscribe(
        (data)=>{
        fetch = data;
        }, 
        (err)=>{console.log("Error in Get Questions")}, 
        ()=>{this.questions = fetch;}
      );
  }

  connectionCheck() : void {
    this.checklistService.connectioncheck().subscribe(data=>this.connectionStatus=data);
  }

  responseYes(i:number):void {
    this.questions[i].response = "YES";
  }

  responseNo(i:number):void {
    this.questions[i].response = "NO";
  }

  getResponse() : void {
    console.log("inside checklist getResponse");
    if(this.checklistService.validated(this.questions)){
      this.checklistService.getResponse(this.questions);
      this.securityService.turnOffSpecialFlag();
      this.router.navigate(['severity']);
    }else{
      console.log("Not Answered");
    }    
  }

  ngOnInit(): void {
    //login comes
    this.securityService.checkAuthFromLocal('checklist', 'backToLogin');
  }
}
