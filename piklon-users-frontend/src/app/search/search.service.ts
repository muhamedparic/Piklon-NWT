import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Article } from '../article/article.model';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private readonly url: string = 'localhost:8080/articles/search';

  constructor(private http: HttpClient) { }

  public search(query: string): Observable<Article> {
    return this.http.get<Article>(this.url + '?query=' + query);
  }
}
