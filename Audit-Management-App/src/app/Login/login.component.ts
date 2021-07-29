import { ProjectDetails } from './../Models/ProjectDetails';
import { SecurityService } from './../Services/security.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private securityService : SecurityService,
    private router : Router,
    private projectDetails : ProjectDetails
    ) { }

  public username : string = "";    // ngModel - takes username from form
  public password : string = "";    // ngModel - takes password from form
  public message : string = "";     // it will be shown when anyone gives wrong credential

  onLogIn(){
    // get the username and password, validate it, send it to SecurityService
    // delegate this info to SecurityService
    this.securityService.createSecuritytokenObservable(this.username, this.password).subscribe(
      data => {
          //checks
          if(data.includes(".")){
            this.message = "";
            this.securityService.setLoginStatus(true);
            this.securityService.setSecurityToken(data);
          }
      },
      err => {
          this.message = "Give Proper Username and Password!!!";
      },
      () => {
        // routes based on authenticationStatus
          if(this.securityService.getLoginStatus()){
            this.securityService.validateToken().subscribe(
              (data) => {
                //checks
                this.projectDetails.Name = data.name;
                this.projectDetails.ProjectName = data.projectName;
                this.projectDetails.Valid = data.valid;
              },
              err =>{},
              ()=>{
                this.router.navigate(['checklists']);            
              }
            );
          }
      }
    );
  }


  ngOnInit(): void {
    this.message = "";
    //when you get the jwtToken in LocalStorage
    this.securityService.resetAll();
  }

}
