import { Component, ViewChild } from '@angular/core';
import { URLSearchParams } from '@angular/http';
import { logging } from 'protractor';
import { HttpClient} from '@angular/common/http'
import {Http, Response, RequestOptions, Headers} from '@angular/http'


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  

  constructor(private httpClient:HttpClient) {}
  LogIn() {
  //alert("hhh")
  //this.testRequest()
  var username = ((document.getElementById("usernameInput") as HTMLInputElement).value);
  var password = ((document.getElementById("passwordInput") as HTMLInputElement).value);
  console.log(username)
  console.log(password)

    this.httpClient.post('http://localhost:8082/users/login',
  {
    "username": username,
    "password": password
  })
  .subscribe(
    (data:any) => {
      var response = data["token"]
    
      if (response == "null") {
        alert("Neuspjesna prijava!")
      }
      else if (response == "Username not found") {
        alert("Username not found")
      }
      else {
        alert("Uspjesna prijava!")
      }
      console.log(data)
    }
  )
  }

  getUsers() {
  alert(this.httpClient.get('http://localhost:8082/users/all'))
  }
  



  /*testRequest() {
    var body = 'alubovac1,pass';
    var headers = new Headers();
    //headers.append('Content-Type', 'application/x-www-form-urlencoded');

    this.http
      .post('http://localhost:8082/users/login',
        body, {
          headers: headers
        })
        .subscribe(data => {
              alert('ok');
        }, error => {
            console.log(JSON.stringify(error.json()));
        });
}*/
}



