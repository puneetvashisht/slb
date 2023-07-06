import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  messages: Array<string> = ['a', 'b']
  constructor() { }

  addMessage(message: string){
    this.messages = [...this.messages, message];
    console.log(this.messages);
  }

  getMessages(): Array<string>{
    return this.messages;
  }
}
