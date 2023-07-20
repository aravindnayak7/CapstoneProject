import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { UserserviceService } from './services/userservice.service';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { CommonModule, NgFor } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CustomerComponent } from './customer/customer.component';
import { BookinghistoryComponent } from './bookinghistory/bookinghistory.component';
import { BookmeetComponent } from './bookmeet/bookmeet.component';
import { AdditemComponent } from './additem/additem.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { RouteService } from './services/route.service';
import { RoomServiceService } from './services/room-service.service';
import { CustomerService } from './services/customer.service';
import { RoomserviceComponent } from './roomservice/roomservice.component';
import { PartnersComponent } from './partners/partners.component';
import { RoomTourComponent } from './room-tour/room-tour.component';
import { ResourcesComponent } from './resources/resources.component';
import { HomeLogoutComponent } from './home-logout/home-logout.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { PaypalComponent } from './paypal/paypal.component';
import { PaymentComponent } from './payment/payment.component';
import { AdminComponent } from './admin/admin.component';
import { AdminhistoryComponent } from './adminhistory/adminhistory.component';
import { AdminnextComponent } from './adminnext/adminnext.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';

import {MatInputModule} from '@angular/material/input';
import { LocationComponent } from './location/location.component';
import { FaqComponent } from './faq/faq.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminheaderComponent } from './adminheader/adminheader.component';
import { SettingsComponent } from './settings/settings.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { CustHistroyComponent } from './cust-histroy/cust-histroy.component';
import { HomeheaderComponent } from './homeheader/homeheader.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    
    HomeComponent,
    CustomerComponent,
    BookinghistoryComponent,
    BookmeetComponent,
    AdditemComponent,
    UserProfileComponent,
    RoomserviceComponent,
    PartnersComponent,
    RoomTourComponent,
    ResourcesComponent,
    HomeLogoutComponent,
    InvoiceComponent,
    PaypalComponent,
    PaymentComponent,
    AdminComponent,
    AdminhistoryComponent,
    AdminnextComponent,
    AdmindashboardComponent,
    LocationComponent,
    FaqComponent,
    AdminloginComponent,
    AdminheaderComponent,
    SettingsComponent,
    FeedbackComponent,
    CustHistroyComponent,
    HomeheaderComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatCardModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MatCheckboxModule,
    NgFor,
    MatExpansionModule,
    CommonModule,
    MatSelectModule,
    MatButtonModule,
    MatInputModule
    
  ],
  providers: [UserserviceService,RouteService,RoomServiceService,CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
