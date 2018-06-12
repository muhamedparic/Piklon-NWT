import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

class Category {
  name: string;
  id: number;
  extraInfoTypes: string[];
}

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css']
})
export class CreateArticleComponent implements OnInit {

  public categories: string[] = [];

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.httpClient.get<Category[]>('http://localhost:8080/categories/all').subscribe(response => {
      console.log(response);
      response.forEach(category => this.categories.push(category.name));
    });
  }

  public submit() {
    let name = document.getElementById('name').value;
    let location = document.getElementById('location').value;
    let price = document.getElementById('price').value;
    let condition = document.getElementById('condition').value;
    let category = document.getElementById('category').value;

    this.httpClient.post('http://localhost:8080/articles/create', {name: name,
                                                                   location: location,
                                                                   price: price,
                                                                   condition: condition,
                                                                   category: category},
                                                                  {observe: 'response'})
    .subscribe(response => {
      if (response.status)
        alert('Article successfully added!');
      else
        alert('Couldn\'t add article');
    })

    return false;
  }
}
