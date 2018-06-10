import { Component, OnInit } from '@angular/core';
import { ArticlePreviewComponent } from './article-preview/article-preview.component';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  username: string = "Test Username";

  constructor() { }

  ngOnInit() {
  }

}
