import { Component, OnInit } from '@angular/core';
import { ArticlePreviewComponent } from '../article-preview/article-preview.component';

class User {
  firstName: string;
  lastName: string;
  userName: string;
  email: string;
  phone: string;
}

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user: User;

  constructor() { }

  ngOnInit() {
  }

}
