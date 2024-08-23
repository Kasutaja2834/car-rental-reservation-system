import { Routes } from '@angular/router';
import { HomePageComponent } from '../app/home/home-page/home-page.component';
import { AboutUsComponent } from '../app/home/about-us/about-us.component';
import { LoginComponent } from '../app/auth/login/login.component';
import { RegistrationComponent } from '../app/auth/registration/registration.component';
import { CarsComponent } from '../app/cars/cars/cars.component';
import { AdminLoginComponent } from '../app/admin/admin-login/admin-login.component';
import { BookingComponent } from '../app/booking/booking/booking.component';
import { GarageComponent } from '../app/user/garage/garage.component';
import { RentedComponent } from '../app/user/rented/rented.component';
import { RenewalComponent } from '../app/user/renewal/renewal.component';
import { PaymentComponent } from '../app/payment/payment/payment.component';
import { AdminPanelComponent } from '../app/admin/admin-panel/admin-panel.component';
import { StatisticsComponent } from '../app/admin/statistics/statistics.component';
import { CarLoanComponent } from '../app/admin/car-management/car-loan/car-loan.component';
import { CarReturnComponent } from '../app/admin/car-management/car-return/car-return.component';
import { CarAdditionComponent } from '../app/admin/car-management/car-addition/car-addition.component';

export const routes: Routes = [
  { path: '', component: HomePageComponent }, 
  { path: 'login', component: LoginComponent },
  { path: 'about-us', component: AboutUsComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'cars', component: CarsComponent },
  { path: 'booking', component: BookingComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'garage', component: GarageComponent },
  { path: 'rented', component: RentedComponent },
  { path: 'renewal', component: RenewalComponent },
  { path: 'admin-login', component: AdminLoginComponent },
  { path: 'admin-panel', component: AdminPanelComponent },
  { path: 'admin-panel/statistics', component: StatisticsComponent },
  { path: 'admin-panel/car-loan', component: CarLoanComponent },
  { path: 'admin-panel/car-return', component: CarReturnComponent },
  { path: 'admin-panel/car-addition', component: CarAdditionComponent },
  { path: '**', redirectTo: '' }  
];
