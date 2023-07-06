import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-dropdown-item',
  templateUrl: './dropdown-item.component.html',
  styleUrls: ['./dropdown-item.component.css']
})
export class DropdownItemComponent {

  @Input('text') text : string = ''
  @Output('itemClick') itemClick : EventEmitter<string>  = new EventEmitter();

  handleItemClick(): void {
    console.log('Handle Item clicked: ' , this.text);
    this.itemClick.emit(this.text)
  }
}
