import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [NgbModule, CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})

export class HeaderComponent {
  isMenuActive = false;

  constructor(private router: Router) {}

  navigateTo(route: string) {
    this.router.navigate([route]);
  }
  

  // Gambos
  toggleMenu() {
    this.isMenuActive = !this.isMenuActive; 
  }

}
