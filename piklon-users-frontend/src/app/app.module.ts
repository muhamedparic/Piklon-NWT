import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router'
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { LoginComponent } from './login/login.component';
import { RegistracijaComponent } from './registracija/registracija.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ArticleComponent } from './article/article.component';
import { ArticlePreviewComponent } from './article-preview/article-preview.component';
import { CommentComponent } from './comment/comment.component';
import { CommentListComponent } from './comment-list/comment-list.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { CommentInputComponent } from './comment-input/comment-input.component';
import { CreateArticleComponent } from './create-article/create-article.component';
import { UserOfTheDayComponent } from './user-of-the-day/user-of-the-day.component';


@NgModule({
  declarations: [
    AppComponent,
    PocetnaComponent,
    LoginComponent,
    RegistracijaComponent,
    NavbarComponent,
    ArticleComponent,
    ArticlePreviewComponent,
    CommentComponent,
    CommentListComponent,
    SearchResultsComponent,
    UserProfileComponent,
    CommentInputComponent,
    CreateArticleComponent,
    UserOfTheDayComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        path: '',
        component: LoginComponent
      },
      {
        path: 'pocetna',
        component: PocetnaComponent
      },
      {
        path: 'registracija',
        component: RegistracijaComponent
      },
      {
         path: 'search',
         component: SearchResultsComponent
      },
      {
        path: 'user_of_the_day',
        component: UserOfTheDayComponent
      },
      {
        path: 'profile',
        component: UserProfileComponent
      },
      {
        path: 'create_article',
        component: CreateArticleComponent
      },
      {
        path: 'article/:id',
        component: ArticleComponent
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
