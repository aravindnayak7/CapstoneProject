import { Component } from '@angular/core';
import { RouteService } from '../services/route.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(private route:RouteService){

  }
login(){
  this.route.routeToLogin();
}
}
