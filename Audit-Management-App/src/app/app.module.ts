import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Login/login.component';
import { ChecklistComponent } from './CheckList/checklist.component';
import { SeverityComponent } from './Severity/severity.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ChecklistComponent,
    SeverityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
