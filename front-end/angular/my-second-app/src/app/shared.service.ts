import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  messages: Array<string> = ['a', 'b']
  constructor() { }
}
