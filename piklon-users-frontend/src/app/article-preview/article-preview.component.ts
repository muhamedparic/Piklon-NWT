import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Article } from '../article/article.model';

@Component({
  selector: 'app-article-preview',
  templateUrl: './article-preview.component.html',
  styleUrls: ['./article-preview.component.css']
})
export class ArticlePreviewComponent implements OnInit {
  productName: string = "";
  productCategory: string = "";
  productPrice: number = -1;

  @Input()
  articleId: number;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    let that: any = this;

    this.httpClient.get('http://localhost:8080/articles/' + this.articleId.toString()).subscribe(response => {
      let article: any = response;

      that.productName = article.name;
      that.productCategory = article.category.name;
      that.productPrice = article.price;
    });
  }

}
