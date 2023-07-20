import { Injectable } from '@angular/core';
import { Admin } from '../admin/Admin';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  delUrl:String="http://localhost:8085/api/admin/delRoomById";
  constructor(private http:HttpClient) { }
  getAdmin():Observable<Admin[]>{
    return this.http.get<Admin[]>("http://localhost:8085/api/admin/getAllRoomDetails");
  }
  // getCustomerList():Observable<Customer[]>{
  //   return this.http.get<Customer[]>("http://localhost:8080/api/v1/getAllcus");
  // }
  addAdmin(aObj:Admin):Observable<Admin>{
    return this.http.post<Admin>("http://localhost:8085/api/admin/SaveRoomDetails",aObj);
  }
  deleteAdmin(id:any):Observable<Admin>{
    return this.http.delete<Admin>(`${this.delUrl}/${id}`);
  }
}
