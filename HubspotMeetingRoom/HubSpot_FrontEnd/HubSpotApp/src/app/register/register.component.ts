import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../services/userservice.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Register } from './register';
import { HttpClient } from '@angular/common/http';
import { RegisterService } from '../services/register.service';
import { RouteService } from '../services/route.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
   registerform:FormGroup
   registerd:Register
   
  constructor(private regService:RegisterService,private regform:FormBuilder,private http:HttpClient,private route:RouteService){
    
    this.registerd = new Register()
    // mobileNumber: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]]
    
    this.registerform = regform.group({

      firstName:['',Validators.required],
      lastName:[''],
      email:['',Validators.required],
      mobileNumber:['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      companyName:['',Validators.required],
      age:[,Validators.required],
      gender:[''],
      password:['',Validators.required]
    })

   
  // }
  // register(){
  //   if(this.registerform.valid){

  //   }else{
  //     alert("please enter all fields..")
  //   }
    // this.userService.addUser(this.registform.value);
  }
  ngOnInit(): void {
    
  }
  register(){
    // if(this.registerform.valid){
      console.log(this.registerform.value)
      this.regService.addUser(this.registerform.value).subscribe(
        data=>{this.registerd = data,alert("Thank You "+data.firstName+" \n Welcome to Hubspot")},
        err=>{console.log(err)}
      );
    // this.http.post("http://localhost:8080/api/v1/user",this.registerform.value).subscribe(
    //   data=>{console.log(data)},
    //   err=>{console.log(err)}
    // )
    console.log("user service called")
    alert("Registration Successfull.. "+`${this.registerd.firstName}`)
    console.log(this.registerd);
    this.route.routeToLogin();
    //  }else{
    //   alert("enter the valid details")
    // }
  }
}
