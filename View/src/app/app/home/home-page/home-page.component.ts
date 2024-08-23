import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css',
})

export class HomePageComponent {
  model: NgbDateStruct | undefined;
  fromDate: NgbDate | null = null; 
  toDate: NgbDate | null = null; 

  constructor(private router: Router) {}

  navigateTo(route: string) {
    this.router.navigate([route]);
  }

  // Метод для обработки выбранных дат
  onDateRangeSelected(dateRange: { fromDate: NgbDate | null, toDate: NgbDate | null }) {
    this.fromDate = dateRange.fromDate;
    this.toDate = dateRange.toDate;
    console.log('Selected Date Range:', this.fromDate, this.toDate); 
  }

}
