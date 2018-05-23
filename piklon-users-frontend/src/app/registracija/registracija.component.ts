import { Component, OnInit, ViewChild } from '@angular/core';
import { URLSearchParams } from '@angular/http';
import { logging } from 'protractor';
import { HttpClient} from '@angular/common/http'
import {Http, Response, RequestOptions, Headers} from '@angular/http'
import {Router} from '@angular/router'

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  constructor(private httpClient:HttpClient, private router: Router) { }

  Registracija(){
    var ime = ((document.getElementById("firstnameInput") as HTMLInputElement).value);
    var prezime = ((document.getElementById("lastnameInput") as HTMLInputElement).value);
    var username = ((document.getElementById("usernameInput") as HTMLInputElement).value);
    var password = ((document.getElementById("password1Input") as HTMLInputElement).value);
    var password = ((document.getElementById("password1Input") as HTMLInputElement).value);
    var email = ((document.getElementById("emailInput") as HTMLInputElement).value);
    var telefon = ((document.getElementById("telefonInput") as HTMLInputElement).value);

    this.httpClient.post('http://localhost:8082/users/insert',
  {
    "first_name": ime,
    "last_name": prezime,
    "username": username,
    "password_hash": password,
    "email": email,
    "phone": telefon
  })
  .subscribe(
    (data:any) => {
      var response = data["status"]
    
      if (response == "Invalid username") {
        alert("Neuspjesna registracija! Username je zauzet.")
      }
      else if (response == "User is registered") {
        alert("Uspjesno ste registrovani!")
        this.router.navigateByUrl('/')
      }
      console.log(data)
    }
  )
  }

  ngOnInit() {
  }

}
