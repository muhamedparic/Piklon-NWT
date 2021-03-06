import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private readonly endpoint: string = '/users/login';
  private readonly tokenName: string = '';
  private readonly authHeader: string = '';

  private readonly headers: Headers =
    new Headers({ 'Content-Type': 'application/json', 'Authorization': this.authHeader });

  constructor(private http: Http) { }

  public login(username: string, password: string): Observable<any> {
    let parameters: string = JSON.stringify({ 'username': username, 'password': password });

    return this.http.post(this.endpoint, parameters, { headers: this.headers })
  }
}
