import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-article-preview',
  templateUrl: './article-preview.component.html',
  styleUrls: ['./article-preview.component.css']
})
export class ArticlePreviewComponent implements OnInit {
  productName: string = "Test Name";
  productCategory: string = "Test Category";
  productPrice: string = "Test Price";
  
  constructor() { }

  ngOnInit() {
  }

}
