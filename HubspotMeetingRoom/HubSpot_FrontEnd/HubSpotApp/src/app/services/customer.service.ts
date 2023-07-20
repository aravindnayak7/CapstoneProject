import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer/Customer';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  delUrl:String="http://localhost:8083/book/v1/delete";
  constructor(private http:HttpClient) { }
  setId(token:string){
    localStorage.setItem("id",token);
  }
  getId(){
    return localStorage.getItem("id");
  }
  getCustomer():Observable<Customer[]>{
    return this.http.get<Customer[]>("http://localhost:8083/book/v1/getAllcus");
  }
  // getCustomerList():Observable<Customer[]>{
  //   return this.http.get<Customer[]>("http://localhost:8080/api/v1/getAllcus");
  // }
  addCustomer(cObj:Customer):Observable<Customer>{
    return this.http.post<Customer>("http://localhost:8083/book/v1/addCustomer",cObj);
  }
  deleteCustomer(id:any):Observable<Customer>{
    this.setId(id);
    return this.http.delete<Customer>(`${this.delUrl}/${id}`);
  }
  getCustomerByEmail():Observable<Customer[]>{
    return this.http.get<Customer[]>(`http://localhost:8083/book/v1/getcusbyid/${this.getId()}`);
  }
  }


