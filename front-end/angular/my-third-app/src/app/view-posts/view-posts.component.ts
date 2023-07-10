import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../model/Post';
@Component({
  selector: 'app-view-posts',
  templateUrl: './view-posts.component.html',
  styleUrls: ['./view-posts.component.css']
})
export class ViewPostsComponent implements OnInit {

  posts : Array<Post> = [];

  constructor(private httpClient: HttpClient){

  }
  ngOnInit(): void {
    console.log('Initialize get req for data from server ...')
    // this.httpClient.get('http://localhost:3000/posts').toPromise()
    // .then((res: any) => {
    //   this.posts = res;
    // })

    this.httpClient.get('http://localhost:3000/posts')
    .subscribe((res: any) => {
        this.posts = res;
      })
  }

  loadData(){
    console.log('Fetch data from server ...')
    this.httpClient.get('http://localhost:3000/posts').toPromise()
    .then((res: any) => {
      this.posts = res;
    })
  }
}
