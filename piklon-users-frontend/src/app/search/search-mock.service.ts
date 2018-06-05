import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, of } from 'rxjs';

import { Article } from '../article/article.model';

@Injectable({
  providedIn: 'root'
})
export class SearchMockService {

  constructor(private httpClient: HttpClient) { }

  search(query: string): Observable<Article[]> {
    let articleList: Article[] = [];

    this.httpClient.get<Article[]>('assets/mock-articles.json').subscribe(articles => {
      articles.forEach(article => {
        if (article.name.includes(query))
          articleList.push(article);
      });
    });

    return of(articleList);
  }
}
