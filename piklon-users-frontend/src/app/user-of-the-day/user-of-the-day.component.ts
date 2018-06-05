import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-of-the-day',
  templateUrl: './user-of-the-day.component.html',
  styleUrls: ['./user-of-the-day.component.css']
})
export class UserOfTheDayComponent implements OnInit {

  private readonly url: string = '/8081/userofday';

  public id: string;
  public username: string;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    let that = this;

    this.httpClient.get(this.url).subscribe(response => {
      let parsed: any = JSON.parse(response as string);

      that.id = parsed['id'];
      that.username = parsed['username'];
    });
  }
}
