import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Audit-Management-App';
  public username : string = "DeepAndSri";  // shows the username in header (keep max-string-length = 10)
  public logStatus : boolean = false;     // it will decide if we want to show the username part or not
                                          // after logging in, the log status will be "true"
}
