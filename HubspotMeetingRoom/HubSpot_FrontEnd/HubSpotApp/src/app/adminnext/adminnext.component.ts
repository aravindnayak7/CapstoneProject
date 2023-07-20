import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Admin } from './Admin';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-adminnext',
  templateUrl: './adminnext.component.html',
  styleUrls: ['./adminnext.component.css']
})
export class AdminnextComponent {
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
  adminBooking(aForm:FormGroup){
    // this.http.post<any>("http://localhost:8080/api/v1/addCustomer",this.cusForm.value).subscribe(
      
    //   res=>{
    //     this.cusForm.reset();
    //   },
    //   err=>{
    //     alert("here")
    //     console.log("here error");
    //   }
    // )
    this.aObj=aForm.value;
    this.aList.push(this.aObj);
    if(aForm.valid){
      this.aForm.reset(),
      this.adminservice.addAdmin(this.aObj).subscribe(
        data=>{},
        err=>console.log()
        
      )
      console.log(this.aObj.roomName);
      console.log(this.aObj.capacity);
      console.log(this.aObj.location);
      console.log(this.aObj.price);
      console.log(this.aObj.details);
      console.log(this.aObj.imgurl);
    }
    
  }
  ngOnInit(): void {
    this.getAdmininfo();
  }
  private getAdmininfo(){
    this.adminservice.getAdmin().subscribe(data => {
      this.aList = data;
      console.log(this.aList)
    });
  }
  delUser(roomId:any){
    console.log(this.aList)
    this.getAdmininfo();
    this.adminservice.deleteAdmin(roomId).subscribe(
      
      (resp) => {
      //  this.ngOnInit();
        this.getAdmininfo();
      }
    );
    // var resp= this.cusservice.deleteCustomer(bookingId);
    // resp.subscribe((data)=>this.cObj=data);
    
   }

}
