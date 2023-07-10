import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ViewPostsComponent } from './view-posts/view-posts.component';
import {HttpClientModule} from '@angular/common/http';
import { AddPostComponent } from './add-post/add-post.component'

@NgModule({
  declarations: [
    AppComponent,
    ViewPostsComponent,
    AddPostComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
