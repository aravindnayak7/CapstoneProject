import { Component } from '@angular/core';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-paypal',
  templateUrl: './paypal.component.html',
  styleUrls: ['./paypal.component.css']
})
export class PaypalComponent {

  constructor(private bookServ:CustomerService){
  }
ngOnInit(){

}
tt = localStorage.getItem("total");

addBooking(){

    alert("payment successfull..");
}
}
