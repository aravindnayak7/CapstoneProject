import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../login/User';
import { Register } from '../register/register';
import { Observable } from 'rxjs';
import { RouteService } from './route.service';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  result:User
  users:User[];
  user:Register
  BearerToken:String;
  foundUser: User | undefined;

  UserUrl :string="http://localhost:8080/auth/user/authUser"; 

  constructor(private httpClient:HttpClient,private router:RouteService) { 
    this.users=[];
    this.BearerToken="";
   this.result=new User();
   this.user=new Register();
  }
  
  //http://localhost:8081/auth/user/authUser

  // dologin(uObj:User):Observable<User>{
  //   console.log(uObj.email)
  //   return this.httpClient.post<User>(this.UserUrl,uObj);
    
  // }
  

  
 
  ngOnInit(){
    // this.http.get<User[]>("http://localhost:8080/api/v3/user").subscribe(
    //   data=>{this.users=data, console.log(this.users)},
    //   err=>err
    // )
    // console.log("hello after"+this.users);
  }
  
  
  
  dologin(user:User):Observable<User>{
      // return this.httpClient.post<User>("http://localhost:8081/auth/user/authUser",user);
      return this.httpClient.post<User>("http://localhost:8086/auth/user/authUser",user);
  }
  setBearerToken(token:string){
    localStorage.setItem("bearer Token",token);
  }
  getBearerToken(){
    return localStorage.getItem("bearer Token");
  }
  setEmail(token:string){
    localStorage.setItem("email",token);
  }
  getEmail(){
    return localStorage.getItem("email");
  }

  
}
