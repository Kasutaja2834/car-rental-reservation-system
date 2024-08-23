import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CarsComponent } from './cars/cars.component';


@NgModule({
  declarations: [
    CarsComponent
  ],
  imports: [
    CommonModule,
  ],
  exports: [
    CarsComponent
  ]
})

export class CarsModule {}
