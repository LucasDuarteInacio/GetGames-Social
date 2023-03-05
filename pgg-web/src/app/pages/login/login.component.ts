import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';

import {ErrorStateMatcher} from '@angular/material/core';
import { TranslateService } from '@ngx-translate/core';


/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{

  constructor(public translate: TranslateService) {
    translate.addLangs(['en', 'pt']);
  }


  loginButtonText = ""
  colsSessionTitle: number = 10;
  colsSessionLogin: number = 8;
  emailFormControl = new FormControl('', [Validators.required, Validators.email]);

  matcher = new MyErrorStateMatcher();


  ngOnInit(): void {
    this.translate.get('LOGIN.FORM.INPUT.BUTTON').subscribe((res: string) => {
      this.loginButtonText = res
  });
  }
 

  onResize(event: any) {
    const windowWidth = 875

    this.colsSessionTitle = (event.target.innerWidth <= windowWidth) ? 0 : 10;
    this.colsSessionLogin = (event.target.innerWidth <= windowWidth) ? 18 : 8;
  }
  

}
