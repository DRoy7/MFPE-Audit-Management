import { ProjectDetails } from './Models/ProjectDetails';
import { LoginStatus } from './Models/LoginStatus';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptorService } from './Services/token-interceptor.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { LoginComponent } from './Login/login.component';
import { ChecklistComponent } from './CheckList/checklist.component';
import { SeverityComponent } from './Severity/severity.component';
import { FormsModule } from '@angular/forms';

import { AuthenticationRequest } from './Models/AuthenticationRequest';
import { SecurityToken } from './Models/SecurityToken';
import { NavHeaderComponent } from './NavHeader/nav-header.component';
import { BackToLoginComponent } from './back-to-login/back-to-login.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ChecklistComponent,
    SeverityComponent,
    NavHeaderComponent,
    BackToLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AuthenticationRequest,
    SecurityToken,
    LoginStatus,
    ProjectDetails,
    {   // for token interceptor
      provide : HTTP_INTERCEPTORS,
      useClass : TokenInterceptorService,
      multi : true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
