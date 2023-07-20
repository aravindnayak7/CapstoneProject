import { Component } from '@angular/core';

@Component({
  selector: 'app-additem',
  templateUrl: './additem.component.html',
  styleUrls: ['./additem.component.css']
})

export class AdditemComponent {
 item1={isChecked:false,value:30};
 item2={isChecked:false,value:50};
 item3={isChecked:false,value:50};
 item4={isChecked:false,value:60};
 item5={isChecked:false,value:70};
 item6={isChecked:false,value:80};

 total=0;
 updateTotal(item:any){
  if(item.isChecked){
    this.total += item.value*7;
  }else{
    this.total -= item.value*7;
  }
  // console.log("total cost is"+this.total);
 
  localStorage.setItem("total",`${this.total}`);
  console.log(localStorage.getItem("total"))
 }

}
