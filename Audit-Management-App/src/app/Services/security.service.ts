import { LoginStatus } from './../Models/LoginStatus';
import { AuthorizationMSClientService } from '../HttpClients/authorization-msclient.service';
import { AuthenticationRequest } from './../Models/AuthenticationRequest';
import { ProjectDetails } from './../Models/ProjectDetails';
import { SecurityToken } from './../Models/SecurityToken';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  constructor(
    // Models
    private token : SecurityToken,
    private loginStatus : LoginStatus,
    private projectDetails : ProjectDetails,
    private authenticationRequest : AuthenticationRequest,
    // services
    private authClient : AuthorizationMSClientService
    ) { }

  createSecuritytokenObservable(username : string, password : string){
    // take result from AuthorizationMSClient service, using the username, passord :: subscribe
    // setting the authenticationRequest object for response body
    this.authenticationRequest.Username = username;
    this.authenticationRequest.Password = password;
    // getting the respone back from Auth-MS through AuthClientService
    return this.authClient.authenticate(this.authenticationRequest);
  }

  validateToken(){
    return this.authClient.validate(this.token);
  }

  setLoginStatus(status : boolean){
    this.loginStatus.Status = status;
  }

  getLoginStatus(){
    return this.loginStatus.Status;
  }
  getSecurityToken(){
    // take result from AuthorizationMSClient service, using the security-token :: subscribe
    return this.token.Jwt;

  }
  setSecurityToken(token : string){
    // take result from AuthorizationMSClient service, using the security-token :: subscribe
    this.token.Jwt = token;
  }

  getProjectDetails() : ProjectDetails{
    return this.projectDetails;
  }

  resetAll(){
    this.token.Jwt = "";
    this.loginStatus.Status = false;
    this.projectDetails.Name = "";
    this.projectDetails.ProjectName = "";
    this.projectDetails.Valid = false;
  }
}
