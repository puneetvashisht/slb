import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {
  @Input('message') message: string = ""
  @Output('greet') eventEmitter: EventEmitter<string> = new EventEmitter();

  sayHelloToMom(){
    this.eventEmitter.emit("I also programmaing Mom! Hi From Me");
  }
}
