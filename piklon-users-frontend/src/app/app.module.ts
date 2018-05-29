import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router'
import { HttpClientModule} from '@angular/common/http'
import { AppComponent } from './app.component';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { LoginComponent } from './login/login.component';
import { RegistracijaComponent } from './registracija/registracija.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ArticleComponent } from './article/article.component';
import { ArticlePreviewComponent } from './article-preview/article-preview.component';


@NgModule({
  declarations: [
    AppComponent,
    PocetnaComponent,
    LoginComponent,
    RegistracijaComponent,
    NavbarComponent,
    ArticleComponent,
    ArticlePreviewComponent
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
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
