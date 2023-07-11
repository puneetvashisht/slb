import { Pipe, PipeTransform } from '@angular/core';
import { Post } from '../components/model/Post';


@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(posts: Array<Post>, ...args: Array<string>): Array<Post> {
    let searchedPosts = posts.filter(post => post.title.startsWith(args[0]))
    return searchedPosts;
  }

}
