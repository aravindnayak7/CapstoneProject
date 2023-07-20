import { Component } from '@angular/core';
import { RouteService } from '../services/route.service';
import * as AOS from 'aos';
@Component({
  selector: 'app-home-logout',
  templateUrl: './home-logout.component.html',
  styleUrls: ['./home-logout.component.css']
})
export class HomeLogoutComponent {
constructor(private route:RouteService){

}
ngOnInit(){
  AOS.init();
}
}
