import { Component } from '@angular/core';
import * as AOS from 'aos';
@Component({
  selector: 'app-partners',
  templateUrl: './partners.component.html',
  styleUrls: ['./partners.component.css']
})
export class PartnersComponent {
  ngOnInit() {
    AOS.init();
  }
}
