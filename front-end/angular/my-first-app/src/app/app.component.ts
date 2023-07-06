import { Component } from '@angular/core';
import { Employee } from './Employee';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // country = 'US';
  countries : Array<string> = ['India', 'Brazil', 'Thailand'];
  employees: Array<Employee> = [
    {id: 34, name: 'Rahul', salary: 33433.3},
    {id: 32, name: 'Priya', salary: 44444.3},
  ]
  cuisines: Array<string> = ['Mexican', 'Chinese', 'North Indian']
}
