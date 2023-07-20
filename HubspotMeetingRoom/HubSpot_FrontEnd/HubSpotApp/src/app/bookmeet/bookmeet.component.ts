import { Component } from '@angular/core';
import { Customer } from './Customer';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CustomerService } from '../services/customer.service';
import { RoomServiceService } from '../services/room-service.service';
import { Rooms } from '../roomservice/roomd';
import { RouteService } from '../services/route.service';

@Component({
  selector: 'app-bookmeet',
  templateUrl: './bookmeet.component.html',
  styleUrls: ['./bookmeet.component.css']
})
export class BookmeetComponent {
  cObj:Customer;
  cusList:Customer[];
 
  cusForm:FormGroup;
  rid:any = "";
  rp:any 
  loc:any
  room:Rooms
  em:string
  constructor(private roomserv:RoomServiceService,private route:RouteService,private http:HttpClient,private fb:FormBuilder,private cusservice:CustomerService){
    this.cObj=new Customer();
    this.cusList=[];
    this.room=new Rooms()
    this.em=""
    this.rid=""
    this.rp=""
    this.loc=""
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
  ngOnInit(): void {
    
    // alert("hello")
    this.cusservice.getCustomer().subscribe(
      noteData => this.cusList = noteData,
      err => console.log(err)
    )
      // this.em = localStorage.getItem("email")
    //  this.roomd = localStorage.getItem("roomD")
     this.rid = localStorage.getItem("rid");
     this.roomserv.getRoomById(this.rid).subscribe(
      data=>{this.room=data},
      err=>{console.log(err)}
     )
    //  this.rp = localStorage.getItem("price")
    //  this.loc = localStorage.getItem("loc")
    // this.getCustomersinfo();
    
  }
  
  cusBooking(cusForm:FormGroup){
    let tt:string
    this.cObj=cusForm.value;
    this.cusList.push(this.cObj);
    window.confirm("Confirm ?")
    if(cusForm.valid){
      this.cusForm.reset(),
      this.cObj.email="user@gmail.com";
      this.cObj.location=this.loc
     
      this.cusservice.addCustomer(this.cObj).subscribe(
        data=>{console.log(data),this.route.routeToPayment()},
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
  
  tt = localStorage.getItem("total");
  
}
