import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Observable } from 'rxjs';

import { SearchService } from '../search/search.service';
import { Article } from '../article/article.model';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {

  public articles: Article[] = [];

  constructor(private route: ActivatedRoute, private searchService: SearchService) { }

  ngOnInit() {
    let query: string;

    this.articles = [
      {
        "id": 1,
        "username": "korisnik_1",
        "name": "VW Golf 5",
        "price": 12500,
        "condition": "USED",
        "location": "Sarajevo",
        "category": "Automobili",
        "creationTime": "2018-05-22 18:23:42"
      },
      {
        "id": 1,
        "username": "korisnik_2",
        "name": "Stan na Koševskom Brdu",
        "price": 70000,
        "condition": "USED",
        "location": "Sarajevo",
        "category": "Stanovi",
        "creationTime": "2018-05-06 11:26:51"
      },
      {
        "id": 1,
        "username": "korisnik_3",
        "name": "Igra GTA 5",
        "price": 65,
        "condition": "NEW",
        "location": "Tuzla",
        "category": "Video igre",
        "creationTime": "2018-05-06 11:26:51"
      }
    ]

    // this.route.queryParams.subscribe(params => {
    //   query = params['query'];
    // });
    //
    // this.searchService.searchMock(query).subscribe(articles => {  // MOCK
    //   this.articles = articles;
    // });
  }
}
