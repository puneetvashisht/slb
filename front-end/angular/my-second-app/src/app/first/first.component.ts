import { Component } from '@angular/core';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
 
})
export class FirstComponent {
  constructor(public sharedService : SharedService){ 
  }

  addMessage(){
    // mutable change
    // this.sharedService.messages.push('c');

    // immutable version of adding new element 
    this.sharedService.messages = [...this.sharedService.messages, 'c'];
    console.log(this.sharedService.messages);
  }
}
