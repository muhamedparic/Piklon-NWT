import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Article } from '../article/article.model.ts';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private const url: string = 'localhost:8080/articles/search';

  constructor(private http: HttpClient) { }

  public search(query: string): Observable<Article> {
    return this.http.get<Article>(url, { 'params': 'query=' + query });
  }
}
