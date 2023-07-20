import { Component } from '@angular/core';
import { Customer } from '../customer/Customer';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CustomerService } from '../services/customer.service';


@Component({
  selector: 'app-bookinghistory',
  templateUrl: './bookinghistory.component.html',
  styleUrls: ['./bookinghistory.component.css']
})
export class BookinghistoryComponent {
  cObj:Customer;
  currentCustomer:Customer[]
  cusList:Customer[];
  cusForm:FormGroup;
  constructor(private http:HttpClient,private fb:FormBuilder,private cusservice:CustomerService){
    this.cObj=new Customer();
    this.cusList=[];
    this.currentCustomer=[];
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
      duration:""
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
