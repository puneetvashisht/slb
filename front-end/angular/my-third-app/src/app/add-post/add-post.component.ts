import { Component } from '@angular/core';
import { PostService } from '../post.service';
@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent {

  constructor(private postService: PostService){

  }

  addPost(title: string, author: string){
    // this.http.post('http://localhost:3000/posts', {title, author})
    // .subscribe(res => console.log(res));

    this.postService.addPost({title, author})
    .subscribe(res => console.log(res));
    
  }

}
