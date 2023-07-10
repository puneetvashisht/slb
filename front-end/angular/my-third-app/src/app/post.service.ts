import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Post } from './model/Post';

const baseUrl : string = 'http://localhost:3000/posts/'

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpClient: HttpClient) { }

  addPost(post: Post):  Observable<any> {
    return this.httpClient.post(baseUrl, post)
  }

  fetchAllPosts(): Observable<any> {
    return this.httpClient.get(baseUrl)
  }
  
  deletePost(id: string): Observable<any>{
    return this.httpClient.delete(baseUrl + id)
  }
}
