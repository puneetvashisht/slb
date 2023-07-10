import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../model/Post';
import { PostService } from '../post.service';
@Component({
  selector: 'app-view-posts',
  templateUrl: './view-posts.component.html',
  styleUrls: ['./view-posts.component.css']
})
export class ViewPostsComponent implements OnInit {

  posts : Array<Post> = [];

  constructor(private postService: PostService){

  }
  ngOnInit(): void {
    console.log('Initialize get req for data from server ...')
    // this.httpClient.get('http://localhost:3000/posts').toPromise()
    // .then((res: any) => {
    //   this.posts = res;
    // })

    this.postService.fetchAllPosts()
    .subscribe((res: any) => {
        this.posts = res;
      })
  }


  deletePost(id: string){
    this.postService.deletePost(id)
    .subscribe(res => {
      console.log(res);
      let remainingPosts = this.posts.filter((post)=> post.id != parseInt(id))
      console.log(remainingPosts);
      this.posts = remainingPosts;
      
    });

    
  }
}
