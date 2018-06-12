import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { ArticleService } from './article.service';
import { Article } from './article.model';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  articleName: string = "";
  articlePrice: number = -1;
  sellerId: string = "";
  category: string = "";

  constructor(private articleService: ArticleService, private route: ActivatedRoute, private httpClient: HttpClient) { }

  ngOnInit() {
    let that: any = this;
    this.route.params.subscribe(params => {
        let id: string = params['id'];
        that.httpClient.get<Article>('http://localhost:8080/articles/' + id).subscribe(response => {
          that.articleName = response.name;
          that.articlePrice = response.price;
          that.category = response.category.name;
        })
      );
    });
  }

}
