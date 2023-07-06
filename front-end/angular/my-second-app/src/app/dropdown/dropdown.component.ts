import { Component } from '@angular/core';

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent {
  show: boolean = false;
  caption: string = 'Select Cuisine'
  cuisines: Array<string> = ['Japanese', 'Continental', 'Indian'];
  toggleShow(): void{
    this.show = !this.show;
  }
  handleItemClickInParent(text: string){
    console.log('Child item selected: ', text);
    this.caption = text
    this.show = false
  }
}
