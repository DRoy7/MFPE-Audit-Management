import { ProjectDetails } from './../Models/ProjectDetails';
import { SecurityToken } from './../Models/SecurityToken';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(
    private token : SecurityToken,
    private projectDetails : ProjectDetails
    ) { }

  createSecuritytoken(username : string, password : string) : SecurityToken{
    // take result from AuthorizationMSClient service, using the username, passord :: subscribe
    return this.token;
  }

  createProjectDetails(token : SecurityToken) : ProjectDetails{
    // take result from AuthorizationMSClient service, using the security-token :: subscribe
    return this.projectDetails;
  }
}
