import { Component } from '@angular/core';
import { Admin } from '../admin/Admin';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { AdminService } from '../services/admin.service';
import * as AOS from 'aos';
@Component({
  selector: 'app-adminhistory',
  templateUrl: './adminhistory.component.html',
  styleUrls: ['./adminhistory.component.css']
})
export class AdminhistoryComponent {
  aObj:Admin;
  aList:Admin[];
  aForm:FormGroup;
  constructor(private http:HttpClient,private fb:FormBuilder,private adminservice:AdminService){
    this.aObj=new Admin();
    this.aList=[];
    this.aForm=fb.group({
      // id:"",  
      roomName:"",
      capacity:"",
      location:"",
      alternatecontactnumber:"",
      price:"",
      details:"",
      imgurl:""
    })
  }
  // ngOnInit(): void {
  //   // alert("hello")
  //   this.cusservice.getCustomer().subscribe(
  //     noteData => this.cusList = noteData,
  //     err => console.log(err)
  //   )
  //   // this.getCustomersinfo();
  // }
  ngOnInit(): void {
    this.getAdmininfo();
    AOS.init();
  }
  private getAdmininfo(){
    this.adminservice.getAdmin().subscribe(data => {
      this.aList = data;
      console.log(this.aList)
    });
  }
  delAdmin(roomId:any){
    console.log(this.aList)
    this.getAdmininfo();
    this.adminservice.deleteAdmin(roomId).subscribe(
     
      (resp) => {
      //  this.ngOnInit();
        this.getAdmininfo(),
        alert("Room Deleted Successfully..");
      }
    );
    // var resp= this.cusservice.deleteCustomer(bookingId);
    // resp.subscribe((data)=>this.cObj=data);
    alert("Room Deleted Successfully..")
   }
}
