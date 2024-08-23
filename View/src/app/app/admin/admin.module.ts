import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { StatisticsComponent } from './statistics/statistics.component';

import { CarLoanComponent } from './car-management/car-loan/car-loan.component';
import { CarReturnComponent } from './car-management/car-return/car-return.component';
import { CarAdditionComponent } from './car-management/car-addition/car-addition.component';


@NgModule({
  declarations: [
    AdminLoginComponent, 
    AdminPanelComponent,
    StatisticsComponent,

    CarLoanComponent,
    CarReturnComponent,
    CarAdditionComponent
  ],
  imports: [
    CommonModule,
  ],
  exports: [
    AdminLoginComponent, 
    AdminPanelComponent,
    StatisticsComponent,   

    CarLoanComponent,
    CarReturnComponent,
    CarAdditionComponent
  ]
})

export class AdminModule {}
