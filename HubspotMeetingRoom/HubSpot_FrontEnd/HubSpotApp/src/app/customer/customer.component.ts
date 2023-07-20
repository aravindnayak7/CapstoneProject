import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Customer } from './Customer';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { CustomerService } from '../services/customer.service';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit{
  cObj:Customer;
  cusList:Customer[];
  cusForm:FormGroup;
  constructor(private http:HttpClient,private fb:FormBuilder,private cusservice:CustomerService){
    this.cObj=new Customer();
    this.cusList=[];
    this.cusForm=fb.group({
      // id:"",  
      username:"",
      designation:"",
      email:"",
      checkin:"",
      checkout:"",
      numberofRooms:"",
      person:"",
      location:"",
      duration:"",
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
  cusBooking(cusForm:FormGroup){
    // this.http.post<any>("http://localhost:8080/api/v1/addCustomer",this.cusForm.value).subscribe(
      
    //   res=>{
    //     this.cusForm.reset();
    //   },
    //   err=>{
    //     alert("here")
    //     console.log("here error");
    //   }
    // )
    this.cObj=cusForm.value;
    this.cusList.push(this.cObj);
    if(cusForm.valid){
      this.cusForm.reset(),
      this.cusservice.addCustomer(this.cObj).subscribe(
        data=>{},
        err=>console.log()
        
      )
      console.log(this.cObj.username);
      console.log(this.cObj.designation);
      console.log(this.cObj.email);
      console.log(this.cObj.checkin);
      console.log(this.cObj.checkout);
      console.log(this.cObj.email);
      console.log(this.cObj.numberofRooms);
      console.log(this.cObj.person);
      console.log(this.cObj.location);
      console.log(this.cObj.duration);
    }
    
  }
  ngOnInit(): void {
    this.getCustomersinfo();
  }
  private getCustomersinfo(){
    this.cusservice.getCustomer().subscribe(data => {
      this.cusList = data;
      console.log(this.cusList)
    });
  }
  delUser(bookingId:number){
    console.log(this.cusList)
    this.getCustomersinfo();
    this.cusservice.deleteCustomer(bookingId).subscribe(
      
      (resp) => {
      //  this.ngOnInit();
        this.getCustomersinfo();
      }
    );
    // var resp= this.cusservice.deleteCustomer(bookingId);
    // resp.subscribe((data)=>this.cObj=data);
    
   }

}
