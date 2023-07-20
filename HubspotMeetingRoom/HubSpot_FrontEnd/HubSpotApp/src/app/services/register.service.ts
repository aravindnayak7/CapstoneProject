import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Register } from '../register/register';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private httpClient:HttpClient) { }

  addUser(rObj:Register):Observable<Register>{
 
    return this.httpClient.post<Register>("http://localhost:8082/api/user",rObj);
    
     }
     
}
