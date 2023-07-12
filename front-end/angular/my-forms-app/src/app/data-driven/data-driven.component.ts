import { Component } from '@angular/core';
import {FormControl, Validators} from '@angular/forms'

@Component({
  selector: 'app-data-driven',
  templateUrl: './data-driven.component.html',
  styleUrls: ['./data-driven.component.css']
})
export class DataDrivenComponent {
  favoriteColorControl = new FormControl('', Validators.required);


  handleSubmit(){
    console.log('handle submit method');
    console.log(this.favoriteColorControl);
    
    console.log(this.favoriteColorControl.value);
    
    
  }
}
