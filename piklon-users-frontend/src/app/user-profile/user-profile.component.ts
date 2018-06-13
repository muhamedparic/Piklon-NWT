import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { ArticlePreviewComponent } from '../article-preview/article-preview.component';

class User {
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  phone: string;
}

class UserOut {
  first_name: string;
  last_name: string;
  username: string;
  email: string;
  phone: string;
}

function toUser(userOut: UserOut): User {
  let u: User = new User();
  u.firstName = userOut.first_name;
  u.lastName = userOut.last_name;
  u.username = userOut.username;
  u.email = userOut.email;
  u.phone = userOut.phone;

  return u;
}

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user: User;
  userId: number;
  articleIds: number[];

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    let that: any = this;

    this.httpClient.get('http://localhost:8082/users/getIdByUsername?username=' + localStorage.getItem('username')).subscribe(response => {
      let id: number = Number(response);

      that.httpClient.get<UserOut>('http://localhost:8082/users/get/' + id.toString()).subscribe(response => {
        that.user = toUser(response);
      });

      that.httpClient.get<number[]>('http://localhost:8080/articlesbyuserid/' + id.toString()).subscribe(response => {
        that.articleIds = response;
      });
    });
  }
}
