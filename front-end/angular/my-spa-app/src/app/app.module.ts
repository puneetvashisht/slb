import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { AddPostComponent } from './components/add-post/add-post.component';
import { ViewPostsComponent } from './components/view-posts/view-posts.component';
import { SearchPipe } from './services/search.pipe';
import { CapitalizePipe } from './services/capitalize.pipe';
import { HttpClientModule } from '@angular/common/http';
import { NgbAlertModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgbdToastGlobal } from './components/toast/toast-global.component';
// import { ToastsContainer } from './components/toast/toast-container.compnent';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    AddPostComponent,
    ViewPostsComponent,
    SearchPipe,
    CapitalizePipe,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    NgbAlertModule,
    NgbdToastGlobal 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
