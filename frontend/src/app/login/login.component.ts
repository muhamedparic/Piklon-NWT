import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginForm: FormGroup = this.formBuilder.group({
    'username': [null, Validators.required],
    'password': [null, Validators.required]
  })

  constructor(private route: ActivatedRoute, private location: Location, private loginService: LoginService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
  }

  public login() {
    this.loginService.login("uname", "pass").subscribe();
  }
}
