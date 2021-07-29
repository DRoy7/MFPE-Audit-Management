import { Router } from '@angular/router';
import { SecurityService } from './../Services/security.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checklist',
  templateUrl: './checklist.component.html',
  styleUrls: ['./checklist.component.css']
})
export class ChecklistComponent implements OnInit {

  public message = "";

  constructor(
    private securityService : SecurityService,
    private router : Router
  ) { }

  ngOnInit(): void {
    if(this.securityService.getLoginStatus()){
      // do nothing
    }
    else{
      // route to backToLogin
      this.router.navigate(['backToLogin']);
    }
  }

}
