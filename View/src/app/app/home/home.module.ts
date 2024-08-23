import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';

import { HomePageComponent  } from './home-page/home-page.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { SharedModule } from '../shared/shared.module';
import { DatepickerRangePopup } from "../shared/datepicker-range-popup/datepicker-range-popup.component";


@NgModule({
  declarations: [
    HomePageComponent,
    AboutUsComponent
  ],
  imports: [
    CommonModule,
    SharedModule, 
    NgbModule,
    FormsModule,
    DatepickerRangePopup
],
  exports: [
    SharedModule,
    HomePageComponent,
    AboutUsComponent,
    NgbModule,
    FormsModule,
    DatepickerRangePopup
  ],
})

export class HomeModule {
  
}
