import { Component } from '@angular/core';
import * as AOS from 'aos';
@Component({
  selector: 'app-resources',
  templateUrl: './resources.component.html',
  styleUrls: ['./resources.component.css']
})
export class ResourcesComponent {
  ngOnInit(){
    AOS.init();
  }
}
