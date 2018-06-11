import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {
  commenterUsername: string = "Test Username";
  commentText: string = "Test Text";
  
  constructor() { }

  ngOnInit() {
  }

}
