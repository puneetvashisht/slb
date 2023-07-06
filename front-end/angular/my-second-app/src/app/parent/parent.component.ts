import { Component } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent {
  message: string = ""
  childMessage: string = ""
  sayHello(){
    this.message = 'Programatic hello from parent!'
  }
  handleGreet(childMessage: string){
    console.log('Greet event from parent ', childMessage);
    this.childMessage = childMessage
  }
}
