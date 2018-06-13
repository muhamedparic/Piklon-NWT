import { Component, OnInit, ViewChild } from '@angular/core';
import { URLSearchParams } from '@angular/http';
import { logging } from 'protractor';
import { HttpClient} from '@angular/common/http'
import {Http, Response, RequestOptions, Headers} from '@angular/http'
import {Router} from '@angular/router'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private httpClient:HttpClient, private router: Router) {}
  LogIn() {
  //alert("hhh")
  //this.testRequest()
  var username = ((document.getElementById("usernameInput") as HTMLInputElement).value);
  var password = ((document.getElementById("passwordInput") as HTMLInputElement).value);

    this.httpClient.post('http://localhost:8082/users/login',
  {
    "username": username,
    "password": password
  })
  .subscribe(
    (data:any) => {
      var response = data["token"];
      localStorage.setItem('token', response);
      localStorage.setItem('username', username);

      if (response == "null") {
        alert("Could not sign in");
      }
      else if (response == "Username not found") {
        alert("Username not found");
      }
      else {
        //alert("Uspjesna prijava!")
        this.router.navigateByUrl('/profile');
      }
    }
  );
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

  ngOnInit() {
    if (localStorage.getItem('token') !== null)
      this.router.navigateByUrl('/profile');
  }

}
