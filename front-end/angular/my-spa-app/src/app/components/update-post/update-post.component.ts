import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-update-post',
  templateUrl: './update-post.component.html',
  styleUrls: ['./update-post.component.css']
})
export class UpdatePostComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private postService : PostService  ) {}
    
ngOnInit() {
  const id = this.route.snapshot.paramMap.get('id');
  console.log('Param id is ', id);
  
  // fetch by id and set the author name in text
}

updatePost(author: string){
  console.log('updagte post ', author);
  
  let id : string = this.route.snapshot.paramMap.get('id') + ""
  this.postService.updatePost(id, author)
  .subscribe(res => {
    console.log(res);

    // change the page to view page
    this.router.navigate(['/view-post']);
  });
}
}
