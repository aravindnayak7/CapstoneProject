import { Component } from '@angular/core';
import * as AOS from 'aos';
@Component({
  selector: 'app-room-tour',
  templateUrl: './room-tour.component.html',
  styleUrls: ['./room-tour.component.css']
})
export class RoomTourComponent {
  ngOnInit(){
    AOS.init();
  }
}
