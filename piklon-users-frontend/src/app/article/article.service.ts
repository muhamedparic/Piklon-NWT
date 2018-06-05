import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private httpClient: HttpClient) { }

  private readonly url: string = 'localhost:8080/articles';

  public findById(id: number): Observable<any> {
    return this.httpClient.get(this.url + '/' + id.toString(), {});
  }
}
