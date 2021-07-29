import { BackToLoginComponent } from './back-to-login/back-to-login.component';
import { ChecklistComponent } from './CheckList/checklist.component';
import { LoginComponent } from './Login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path : "", component : LoginComponent},  // login in beginning
  {path : "login", component : LoginComponent},  // login
  {path : "checklists", component : ChecklistComponent},  // checklists
  {path : "backToLogin", component : BackToLoginComponent}, // if unauthorized access happens
  {path : "**", component : LoginComponent} // if nothing matches

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
