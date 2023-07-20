

import { Component } from '@angular/core';
import { Admin } from './Admin';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  aObj:Admin;
  imageLink:String = "";
  aList:Admin[];
  aForm:FormGroup;
  constructor(private http:HttpClient,private fb:FormBuilder,private adminservice:AdminService){
    this.aObj=new Admin();
    this.aList=[];
    
    this.aForm=fb.group({
      // id:"",  
      // 
      roomName:['',Validators.required],
      capacity:['',Validators.required],
      location:['',Validators.required],
      alternatecontactnumber:['',Validators.required,Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")],
      price:["",Validators.required],
      details:["",Validators.required],
      imgurl:['',Validators.required]
    })
  }
 
  ngOnInit(): void {
     
    // alert("hello")
    this.adminservice.getAdmin().subscribe(
      noteData => this.aList = noteData,
      err => console.log(err)
    )
    // this.getCustomersinfo();
  }
  adminBooking(aForm:FormGroup){
    
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
}
