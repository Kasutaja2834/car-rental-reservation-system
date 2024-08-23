import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GarageComponent } from './garage/garage.component';
import { RentedComponent } from './rented/rented.component';
import { RenewalComponent } from './renewal/renewal.component'

@NgModule({
  declarations: [
    GarageComponent,
    RentedComponent,
    RenewalComponent
  ],
  imports: [
    CommonModule,
  ],
  exports: [
    GarageComponent,
    RentedComponent,
    RenewalComponent
  ]
})

export class UserModule {}
