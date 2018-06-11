import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ArticleService } from './article.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  articleName: string = "";
  sellerId: string = "";
  category: string = "";

  constructor(private articleService: ArticleService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      let id: number = Number(params['id']);
      this.articleService.findById(id).subscribe(response => {
        let article: any = JSON.parse(response.text());
        this.articleName = article.name;
        this.sellerId = article.userId;
        this.category = article.category.name;
      }, error => {
        console.log('HTTP request error for articleId=' + id.toString());
      });
    });
  }

}
