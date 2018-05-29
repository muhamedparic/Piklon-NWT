import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  articleName: string = "naziv artikla";
  sellerId: string = "id prodavača";
  category: string = "kategorija";
  
  constructor() { }

  ngOnInit() {
  }

}
