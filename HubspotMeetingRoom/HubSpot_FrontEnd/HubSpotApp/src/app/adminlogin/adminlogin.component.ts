import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RouteService } from '../services/route.service';
import { UserserviceService } from '../services/userservice.service';
import { User } from '../login/User';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {
  loginform:FormGroup;
  adminUser:User
  constructor(private userService:UserserviceService,private logForm:FormBuilder,private rooute:RouteService){
    this.adminUser = new User()
    this.loginform = logForm.group({
      email:['',Validators.compose([Validators.required,Validators.minLength(3),Validators.email],)],
      password:['',Validators.compose([Validators.required,Validators.minLength(5)])]
    })
  }
  login(){   
     if(this.loginform.valid){
      console.log(this.loginform.value);
      this.adminUser = this.loginform.value
      // alert("login success")
      // this.userService.dologin(this.loginform.value).subscribe(
      //   data=>{console.log("login success"),alert("login success"),console.log(data),this.rooute.routeToLogoutHome()},
      //   err=>{console.log(err),alert("Username or password is invalid"),this.rooute.routeToLogin()}
      // )
      if(this.adminUser.email == "admin@gmail.com" && this.adminUser.password=="password"){
        this.rooute.routeToAdminDash();
      }else{
        alert("your not Autherised to login here")
      }
     }else{
      console.log("wrong detaiils")
      alert("Enter valid details")
     }
    
  }
}
