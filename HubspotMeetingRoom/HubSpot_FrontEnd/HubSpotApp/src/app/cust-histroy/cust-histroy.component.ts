import { Component } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { Customer } from '../customer/Customer';

@Component({
  selector: 'app-cust-histroy',
  templateUrl: './cust-histroy.component.html',
  styleUrls: ['./cust-histroy.component.css']
})
export class CustHistroyComponent {
constructor(private cusServ:CustomerService){
this.customer=[]
}
customer:Customer[]
id:number = 56
ngOnInit(){
  this.cusServ.getCustomerByEmail().subscribe(
    data=>{
      this.customer=data
    },
    err=>{console.log(err)}
  );
}
}
