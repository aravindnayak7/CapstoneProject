import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Rooms } from './roomd';
import { Router } from '@angular/router';
import { RoomServiceService } from '../services/room-service.service';

@Component({
  selector: 'app-roomservice',
  templateUrl: './roomservice.component.html',
  styleUrls: ['./roomservice.component.css']
})
export class RoomserviceComponent implements OnInit{

  panelOpenState = false

  rObj:Rooms;
 rList:Rooms[];
  rForm:FormGroup;
  constructor(private http:HttpClient,private fb:FormBuilder,private roomservice:RoomServiceService, private router: Router){
    this.rObj=new Rooms();
    this.rList=[];
    this.rForm=fb.group({
      roomId:"",
      roomName:"",
      capacity:"",
      location:"",
        price:null
    }
    )
  }


 
  ngOnInit(): void {
    // this.roomdata1=this.roomDetails()
    // console.log(room);
    this.roomservice.getRoomDetails().subscribe(

      roomd=>{
        this.rList=roomd;
        console.log(roomd, this.rList)},
      err=>{}
    )
    
    
  }

    getRoomById(roomId: any) {
     return this.roomservice.getRoomById(roomId).subscribe(roomData => {
        console.log(roomData);
      })
    }

  updateRoom(roomId:any, room: any)
  {
    this.roomservice.updateRoom(roomId, room).subscribe(room=>{
      console.log(room);
      
    })
  
  }


  bookRoom(id:string) {
    // Logic to book the room
    
    // localStorage.setItem("roomD",detail);
    localStorage.setItem("rid",id);
    // localStorage.setItem("roomD",price);
    //  localStorage.setItem("roomD",loc);
    this.router.navigate(['/bookingservice']); // Navigate to roombooking page
  }

}




