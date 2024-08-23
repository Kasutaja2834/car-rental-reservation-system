import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { HomeModule } from './app/home/home.module';
import { AuthModule } from './app/auth/auth.module';
import { CarsModule } from './app/cars/cars.module';
import { BookingModule } from './app/booking/booking.module';
import { UserModule } from './app/user/user.module';
import { PaymentModule } from './app/payment/payment.module';
import { AdminModule } from './app/admin/admin.module';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HomeModule, 
    AuthModule, 
    CarsModule, 
    BookingModule, 
    UserModule, 
    PaymentModule, 
    AdminModule
  ],

  templateUrl: './app.component.html',
})

export class AppComponent {
  title = 'View';
}
